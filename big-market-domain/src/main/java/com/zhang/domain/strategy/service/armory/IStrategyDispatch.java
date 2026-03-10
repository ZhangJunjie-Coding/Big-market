package com.zhang.domain.strategy.service.armory;

/**
 * @Author: ZhangJunjie
 * @Description: 策略抽奖的调度
 * @DateTime: 2026/3/21 20:50
 **/
public interface IStrategyDispatch {

    /**
     * 获取抽奖策略装配的随机结果
     * @param strategyId
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);

    Integer getRandomAwardId(Long strategyId,String ruleWeightValue);
}
