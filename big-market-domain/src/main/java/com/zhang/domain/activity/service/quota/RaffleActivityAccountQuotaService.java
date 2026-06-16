package com.zhang.domain.activity.service.quota;

import com.zhang.domain.activity.model.aggregate.CreateQuotaOrderAggregate;
import com.zhang.domain.activity.model.entity.*;
import com.zhang.domain.activity.model.valobj.ActivitySkuStockKeyVO;
import com.zhang.domain.activity.model.valobj.OrderStateVO;
import com.zhang.domain.activity.repository.IActivityRepository;
import com.zhang.domain.activity.service.IRaffleActivitySkuStockService;
import com.zhang.domain.activity.service.quota.rule.factory.DefaultActivityChainFactory;
import com.zhang.domain.support.id.IIdGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description 抽奖活动服务
 */
@Service
public class RaffleActivityAccountQuotaService extends AbstractRaffleActivityAccountQuota implements IRaffleActivitySkuStockService {

    private final IIdGenerator iIdGenerator;

    public RaffleActivityAccountQuotaService(IActivityRepository activityRepository, DefaultActivityChainFactory defaultActivityChainFactory, IIdGenerator iIdGenerator) {
        super(activityRepository, defaultActivityChainFactory);
        this.iIdGenerator = iIdGenerator;
    }

    @Override
    protected void doSaveOrder(CreateQuotaOrderAggregate createQuotaOrderAggregate) {
        activityRepository.doSaveOrder(createQuotaOrderAggregate);
    }

    @Override
    protected CreateQuotaOrderAggregate buildOrderAggregate(SkuRechargeEntity skuRechargeEntity, ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        // 订单实体对象
        ActivityOrderEntity activityOrderEntity = new ActivityOrderEntity();
        activityOrderEntity.setUserId(skuRechargeEntity.getUserId());
        activityOrderEntity.setSku(skuRechargeEntity.getSku());
        activityOrderEntity.setActivityId(activityEntity.getActivityId());
        activityOrderEntity.setActivityName(activityEntity.getActivityName());
        activityOrderEntity.setStrategyId(activityEntity.getStrategyId());
        // 雪花算法生成唯一ID
        activityOrderEntity.setOrderId(String.valueOf(iIdGenerator.nextId()));
        activityOrderEntity.setOrderTime(new Date());
        activityOrderEntity.setTotalCount(activityCountEntity.getTotalCount());
        activityOrderEntity.setDayCount(activityCountEntity.getDayCount());
        activityOrderEntity.setMonthCount(activityCountEntity.getMonthCount());
        activityOrderEntity.setState(OrderStateVO.completed);
        activityOrderEntity.setOutBusinessNo(skuRechargeEntity.getOutBusinessNo());

        // 构建聚合对象
        return CreateQuotaOrderAggregate.builder()
                .userId(skuRechargeEntity.getUserId())
                .activityId(activitySkuEntity.getActivityId())
                .totalCount(activityCountEntity.getTotalCount())
                .dayCount(activityCountEntity.getDayCount())
                .monthCount(activityOrderEntity.getMonthCount())
                .activityOrderEntity(activityOrderEntity)
                .build();
    }

    @Override
    public ActivitySkuStockKeyVO takeQueueValue() throws InterruptedException {
        return activityRepository.takeQueueValue();
    }

    @Override
    public void clearQueueValue() {

        activityRepository.clearQueueValue();
    }

    @Override
    public void updateActivitySkuStock(Long sku) {
        activityRepository.updateActivitySkuStock(sku);

    }

    @Override
    public void clearActivitySkuStock(Long sku) {
        activityRepository.clearActivitySkuStock(sku);
    }

    @Override
    public Integer queryRaffleActivityAccountDayPartakeCount(Long activityId, String userId) {
        return activityRepository.queryRaffleActivityAccountDayPartakeCount(activityId,userId);
    }

    @Override
    public void markActivitySkuStockZero(Long sku) {
        activityRepository.markActivitySkuStockZero(sku);
    }

    @Override
    public boolean isActivitySkuStockZero(Long sku) {
        return activityRepository.isActivitySkuStockZero(sku);
    }
}
