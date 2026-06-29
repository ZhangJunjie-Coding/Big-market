package com.zhang.domain.activity.service;

import com.zhang.domain.activity.model.entity.SkuProductEntity;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description:  sku商品服务接口
 * @DateTime: 2026/6/29 8:38
 **/
public interface IRaffleActivitySkuProductService {
    /**
     * 查询当前活动ID下，创建的 sku 商品。「sku可以兑换活动抽奖次数」
     * @param activityId 活动ID
     * @return 返回sku商品集合
     */
    List<SkuProductEntity> querySkuProductEntityListByActivityId(Long activityId);

}
