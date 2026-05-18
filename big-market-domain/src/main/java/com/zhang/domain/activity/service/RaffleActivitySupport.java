package com.zhang.domain.activity.service;

import com.zhang.domain.activity.model.entity.ActivityCountEntity;
import com.zhang.domain.activity.model.entity.ActivityEntity;
import com.zhang.domain.activity.model.entity.ActivitySkuEntity;
import com.zhang.domain.activity.repository.IActivityRepository;
import com.zhang.domain.activity.service.rule.factory.DefaultActivityChainFactory;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖活动的支撑类
 * @DateTime: 2026/5/18 14:24
 **/
public class RaffleActivitySupport {
    protected DefaultActivityChainFactory defaultActivityChainFactory;

    protected IActivityRepository activityRepository;

    public RaffleActivitySupport(IActivityRepository activityRepository, DefaultActivityChainFactory defaultActivityChainFactory) {
        this.activityRepository = activityRepository;
        this.defaultActivityChainFactory = defaultActivityChainFactory;
    }

    public ActivitySkuEntity queryActivitySku(Long sku) {
        return activityRepository.queryActivitySku(sku);
    }

    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }

    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityCountId);
    }

}
