package com.zhang.trigger.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖请求参数
 * @DateTime: 2026/4/11 16:03
 **/
@Data
public class RaffleStrategyRequestDTO implements Serializable {
    // 抽奖策略ID
    private Long strategyId;
}
