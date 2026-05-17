package com.zhang.infrastructure.persistent.repository;

import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import cn.bugstack.middleware.db.router.strategy.IDBRouterStrategy;
import com.zhang.domain.activity.model.aggregate.CreateOrderAggregate;
import com.zhang.domain.activity.model.entity.ActivityCountEntity;
import com.zhang.domain.activity.model.entity.ActivityEntity;
import com.zhang.domain.activity.model.entity.ActivityOrderEntity;
import com.zhang.domain.activity.model.entity.ActivitySkuEntity;
import com.zhang.domain.activity.model.valobj.ActivityStateVO;
import com.zhang.domain.activity.repository.IActivityRepository;
import com.zhang.infrastructure.persistent.dao.*;
import com.zhang.infrastructure.persistent.po.*;
import com.zhang.infrastructure.persistent.redis.IRedisService;
import com.zhang.types.common.Constants;
import com.zhang.types.enums.ResponseCode;
import com.zhang.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: ZhangJunjie
 * @Description: 活动仓储服务
 * @DateTime: 2026/5/16 22:30
 **/
@Slf4j
@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IRedisService redisService;
    @Resource
    private IRaffleActivityDao raffleActivityDao;
    @Resource
    private IRaffleActivitySkuDao raffleActivitySkuDao;
    @Resource
    private IRaffleActivityCountDao raffleActivityCountDao;

    @Resource
    private IRaffleActivityOrderDao raffleActivityOrderDao;

    @Resource
    private IRaffleActivityAccountDao raffleActivityAccountDao;
    @Resource
    private TransactionTemplate transactionTemplate;
    @Resource
    private IDBRouterStrategy dbRouter;

    @Override
    public ActivitySkuEntity queryActivitySku(Long sku) {
        RaffleActivitySku raffleActivitySku = raffleActivitySkuDao.queryActivitySku(sku);
        return ActivitySkuEntity.builder()
                .sku(raffleActivitySku.getSku())
                .activityId(raffleActivitySku.getActivityId())
                .activityCountId(raffleActivitySku.getActivityCountId())
                .stockCount(raffleActivitySku.getStockCount())
                .stockCountSurplus(raffleActivitySku.getStockCountSurplus())
                .build();
    }

    @Override
    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        // 优先从缓存获取
        String cacheKey = Constants.RedisKey.ACTIVITY_KEY + activityId;
        ActivityEntity activityEntity = redisService.getValue(cacheKey);
        if (null != activityEntity) return activityEntity;
        // 从库中获取数据
        RaffleActivity raffleActivity = raffleActivityDao.queryRaffleActivityByActivityId(activityId);
        activityEntity = ActivityEntity.builder()
                .activityId(raffleActivity.getActivityId())
                .activityName(raffleActivity.getActivityName())
                .activityDesc(raffleActivity.getActivityDesc())
                .beginDateTime(raffleActivity.getBeginDateTime())
                .endDateTime(raffleActivity.getEndDateTime())
                .strategyId(raffleActivity.getStrategyId())
                .state(ActivityStateVO.valueOf(raffleActivity.getState()))
                .build();
        redisService.setValue(cacheKey, activityEntity);
        return activityEntity;
    }

    @Override
    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        // 优先从缓存获取
        String cacheKey = Constants.RedisKey.ACTIVITY_COUNT_KEY + activityCountId;
        ActivityCountEntity activityCountEntity = redisService.getValue(cacheKey);
        if (null != activityCountEntity) return activityCountEntity;
        // 从库中获取数据
        RaffleActivityCount raffleActivityCount = raffleActivityCountDao.queryRaffleActivityCountByActivityCountId(activityCountId);
        activityCountEntity = ActivityCountEntity.builder()
                .activityCountId(raffleActivityCount.getActivityCountId())
                .totalCount(raffleActivityCount.getTotalCount())
                .dayCount(raffleActivityCount.getDayCount())
                .monthCount(raffleActivityCount.getMonthCount())
                .build();
        redisService.setValue(cacheKey, activityCountEntity);
        return activityCountEntity;
    }

    @Override
    public void doSaveOrder(CreateOrderAggregate createOrderAggregate) {
        // 订单对象
        ActivityOrderEntity activityOrderEntity = createOrderAggregate.getActivityOrderEntity();
        RaffleActivityOrder raffleActivityOrder = new RaffleActivityOrder();

        raffleActivityOrder.setUserId(createOrderAggregate.getUserId());
        raffleActivityOrder.setSku(createOrderAggregate.getActivityOrderEntity().getSku());
        raffleActivityOrder.setActivityId(createOrderAggregate.getActivityId());
        raffleActivityOrder.setActivityName(createOrderAggregate.getActivityOrderEntity().getActivityName());
        raffleActivityOrder.setStrategyId(createOrderAggregate.getActivityOrderEntity().getStrategyId());
        raffleActivityOrder.setOrderId(createOrderAggregate.getActivityOrderEntity().getOrderId());
        raffleActivityOrder.setOrderTime(createOrderAggregate.getActivityOrderEntity().getOrderTime());
        raffleActivityOrder.setTotalCount(createOrderAggregate.getTotalCount());
        raffleActivityOrder.setDayCount(createOrderAggregate.getDayCount());
        raffleActivityOrder.setMonthCount(createOrderAggregate.getMonthCount());
        raffleActivityOrder.setState(createOrderAggregate.getActivityOrderEntity().getState().getCode());
        raffleActivityOrder.setOutBusinessNo(createOrderAggregate.getActivityOrderEntity().getOutBusinessNo());

        // 账户对象
        RaffleActivityAccount raffleActivityAccount = new RaffleActivityAccount();
        raffleActivityAccount.setUserId(createOrderAggregate.getUserId());
        raffleActivityAccount.setActivityId(createOrderAggregate.getActivityId());
        raffleActivityAccount.setTotalCount(createOrderAggregate.getTotalCount());
        raffleActivityAccount.setTotalCountSurplus(createOrderAggregate.getTotalCount());
        raffleActivityAccount.setDayCount(createOrderAggregate.getDayCount());
        raffleActivityAccount.setDayCountSurplus(createOrderAggregate.getDayCount());
        raffleActivityAccount.setMonthCount(createOrderAggregate.getMonthCount());
        raffleActivityAccount.setMonthCountSurplus(createOrderAggregate.getMonthCount());

        try {
            // 以用户ID作为切分键，通过doRouter设定路由【这样就保证了下面的操作，都是同一个连接下，也就保证了事务的特性】
            dbRouter.doRouter(createOrderAggregate.getUserId());
            // 编程式事务
            Object execute = transactionTemplate.execute(status -> {
                try {
                    // 1.写入订单
                    raffleActivityOrderDao.insert(raffleActivityOrder);
                    // 2.更新账户
                    int count = raffleActivityAccountDao.updateAccountQuota(raffleActivityAccount);

                    // 3.创建账户 - 更新为0，则账户不存在，创建新账户
                    if(0 == count){
                        raffleActivityAccountDao.insert(raffleActivityAccount);
                    }
                    return 1;
                } catch (DuplicateKeyException e) {
                    status.setRollbackOnly();
                    log.error("写入订单记录,唯一索引冲突 userId:{} activityId: {},sku: {}",
                            activityOrderEntity.getUserId(),
                            activityOrderEntity.getActivityId(),
                            activityOrderEntity.getSku());
                    throw new AppException(ResponseCode.INDEX_DUP.getCode(),
                            ResponseCode.INDEX_DUP.getInfo());
                }
            });
        } finally {
            dbRouter.clear();
        }
    }
}
