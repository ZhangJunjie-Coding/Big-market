package com.zhang.domain.strategy.service.rule.tree.fatory.engine;

import com.zhang.domain.strategy.service.rule.tree.fatory.DefaultTreeFactory;

import java.util.Date;

/**
 * @Author: ZhangJunjie
 * @Description: 规则树组合接口
 * @DateTime: 2026/3/30 15:56
 **/
public interface IDecisionTreeEngine {
    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId, Date endDateTime);
}
