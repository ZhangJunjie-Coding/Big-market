package com.zhang.domain.activity.service.armory;

/**
 * @Author: ZhangJunjie
 * @Description: 活动装配预热
 * @DateTime: 2026/5/17 21:48
 **/
public interface IActivityArmory {

    boolean assembleActivitySkuByActivityId(Long activityId);

    boolean assembleActivitySku(Long sku);
}
