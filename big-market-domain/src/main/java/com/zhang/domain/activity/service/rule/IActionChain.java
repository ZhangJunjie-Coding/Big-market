package com.zhang.domain.activity.service.rule;

import com.zhang.domain.activity.model.entity.ActivityCountEntity;
import com.zhang.domain.activity.model.entity.ActivityEntity;
import com.zhang.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @Author: ZhangJunjie
 * @Description: 下单规则过滤接口
 * @DateTime: 2026/5/17 11:43
 **/
public interface IActionChain extends IActionChainArmory {
    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);
}
