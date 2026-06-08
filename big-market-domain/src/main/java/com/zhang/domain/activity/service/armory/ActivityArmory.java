package com.zhang.domain.activity.service.armory;

import com.zhang.domain.activity.model.entity.ActivitySkuEntity;
import com.zhang.domain.activity.repository.IActivityRepository;
import com.zhang.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 活动sku预热
 * @DateTime: 2026/5/17 21:49
 **/
@Slf4j
@Service
public class ActivityArmory implements IActivityArmory, IActivityDispatch {

    @Resource
    private IActivityRepository activityRepository;

    @Override
    public boolean assembleActivitySkuByActivityId(Long activityId) {
        List<ActivitySkuEntity> activitySkuEntities = activityRepository.queryActivitySkuListByActivityId(activityId);
        for (ActivitySkuEntity activitySkuEntity: activitySkuEntities){
            cacheActivitySkuStockCount(activitySkuEntity.getSku(),activitySkuEntity.getStockCountSurplus());
            // 预热活动次数【查询时预热到缓存】
            activityRepository.queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());
        }
        // 预热活动【查询时预热到缓存】
        activityRepository.queryRaffleActivityByActivityId(activityId);
        return true;
    }

    @Override
    public boolean assembleActivitySku(Long sku) {

        // 预热活动【查询时预热到缓存】
        ActivitySkuEntity activitySkuEntity = activityRepository.queryActivitySku(sku);
        // 预热活动次数 【查询时预热到缓存】
        cacheActivitySkuStockCount(sku, activitySkuEntity.getStockCount());
        return false;
    }

    private void cacheActivitySkuStockCount(Long sku, Integer stockCount) {
        String cacheKey = Constants.RedisKey.ACTIVITY_SKU_STOCK_COUNT_KEY + sku;
        activityRepository.cacheActivitySkuStockCount(cacheKey, stockCount);
    }

    @Override
    public boolean subtractionActivitySkuStock(Long sku, Date endDateTime) {
        String cacheKey = Constants.RedisKey.ACTIVITY_SKU_STOCK_COUNT_KEY + sku;
        return activityRepository.subtractionActivitySkuStock(sku, cacheKey, endDateTime);
    }
}
