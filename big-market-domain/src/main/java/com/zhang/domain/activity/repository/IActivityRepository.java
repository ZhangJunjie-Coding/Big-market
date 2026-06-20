package com.zhang.domain.activity.repository;

import com.zhang.domain.activity.model.aggregate.CreateQuotaOrderAggregate;
import com.zhang.domain.activity.model.aggregate.CreatePartakeOrderAggregate;
import com.zhang.domain.activity.model.entity.*;
import com.zhang.domain.activity.model.valobj.ActivitySkuStockKeyVO;

import java.util.Date;
import java.util.List;

/**
 * @description 活动仓储接口
 */
public interface IActivityRepository {

    ActivitySkuEntity queryActivitySku(Long sku);

    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    void doSaveOrder(CreateQuotaOrderAggregate createQuotaOrderAggregate);

    void cacheActivitySkuStockCount(String cacheKey, Integer stockCount);

    boolean subtractionActivitySkuStock(Long sku, String cacheKey, Date endDateTime);

    void activitySkuStockConsumeSendQueue(ActivitySkuStockKeyVO activitySkuStockKeyVO);

    ActivitySkuStockKeyVO takeQueueValue();

    void clearQueueValue();

    void updateActivitySkuStock(Long sku);

    void clearActivitySkuStock(Long sku);

    /**
     * 查询未使用的订单记录
     * @param partakeRaffleActivityEntity
     * @return
     */
    UserRaffleOrderEntity queryNoUsedRaffleOrder(PartakeRaffleActivityEntity partakeRaffleActivityEntity);

    void saveCreatePartakeOrderAggregate(CreatePartakeOrderAggregate createPartakeOrderAggregate);

    ActivityAccountEntity queryActivityAccountByUserId(String userId, Long activityId);

    ActivityAccountMonthEntity queryActivityAccountMonthByUserId(String userId, Long activityId, String month);

    ActivityAccountDayEntity queryActivityAccountDayByUserId(String userId, Long activityId, String day);

    List<ActivitySkuEntity> queryActivitySkuListByActivityId(Long activityId);

    Integer queryRaffleActivityAccountDayPartakeCount(Long activityId, String userId);

    /**
     * 标记 sku 库存已归零（加入 Redis Set）
     */
    void markActivitySkuStockZero(Long sku);

    /**
     * 判断 sku 库存是否已归零
     */
    boolean isActivitySkuStockZero(Long sku);

    Integer queryRaffleActivityAccountPartakeCount(Long activityId, String userId);

    ActivityAccountEntity queryActivityAccountEntity(Long activityId, String userId);
}
