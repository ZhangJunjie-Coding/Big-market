package com.zhang.trigger.api.dto;

import lombok.Data;

/**
 * @Author: ZhangJunjie
 * @Description:  抽奖策略规则，权重配置，查询N次抽奖可解锁奖品范围，请求对象
 * @DateTime: 2026/6/19 23:03
 **/
@Data
public class RaffleStrategyRuleWeightRequestDTO {

    // 用户ID
    private String userId;
    // 抽奖活动ID
    private Long activityId;

}
