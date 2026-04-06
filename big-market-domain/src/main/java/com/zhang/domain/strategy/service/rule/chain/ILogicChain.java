package com.zhang.domain.strategy.service.rule.chain;

import com.zhang.domain.strategy.service.rule.chain.facotry.DefaultChainFactory;

/**
 * @Author: ZhangJunjie
 * @Description: 责任链接口
 * @DateTime: 2026/3/29 20:57
 **/
public interface ILogicChain extends ILogicChainArmory{
    /**
     * 责任链接口
     * @param userId 用户ID
     * @param strategyId 抽奖策略ID
     * @return 奖品ID
     */
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);

}
