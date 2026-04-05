package com.zhang.domain.strategy.service.rule.tree.fatory.engine;

import com.zhang.domain.strategy.service.rule.tree.fatory.DefaultTreeFactory;

/**
 * @Author: ZhangJunjie
 * @Description: 规则树组合接口
 * @DateTime: 2026/3/30 15:56
 **/
public interface IDecisionTreeEngine {
   DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);
}
