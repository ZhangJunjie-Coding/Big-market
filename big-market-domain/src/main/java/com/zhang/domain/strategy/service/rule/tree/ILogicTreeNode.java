package com.zhang.domain.strategy.service.rule.tree;

import com.zhang.domain.strategy.service.rule.tree.fatory.DefaultTreeFactory;

import java.util.Date;

/**
 * @Author: ZhangJunjie
 * @Description: 规则树接口
 * @DateTime: 2026/3/30 15:21
 **/
public interface ILogicTreeNode {
    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue, Date endDateTime);
}
