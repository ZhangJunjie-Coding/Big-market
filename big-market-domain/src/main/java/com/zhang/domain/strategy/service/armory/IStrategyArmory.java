package com.zhang.domain.strategy.service.armory;

/**
 * @Author: ZhangJunjie
 * @Description: 策略装配工厂, 负责初始化策略计算(也就是抽奖策略的初始化)
 * @DateTime: 2026/3/19 21:02
 **/
public interface IStrategyArmory {

    /**
     * 装配抽奖策略配置 “触发的时机可以为活动审核通过后进行调用”
     *
     * @param strategyId 策略ID
     */
    boolean assembleLotteryStrategy(Long strategyId);

}
