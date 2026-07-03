package com.zhang.trigger.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖奖品列表, 请求对象
 * @DateTime: 2026/4/11 15:49
 **/
@Data
public class RaffleAwardListRequestDTO implements Serializable {
    // 抽奖策略ID
    @Deprecated
    private Long strategyId;
    // 活动ID
    private Long activityId;
    // 用户ID
    private String userId;

}
