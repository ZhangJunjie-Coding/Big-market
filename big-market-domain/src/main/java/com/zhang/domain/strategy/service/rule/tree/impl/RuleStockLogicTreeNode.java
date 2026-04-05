package com.zhang.domain.strategy.service.rule.tree.impl;

import com.zhang.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.zhang.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.zhang.domain.strategy.service.rule.tree.fatory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangJunjie
 * @description 库存扣减节点
 * @DateTime: 2026/3/30 15:56
 */
@Slf4j
@Component("rule_stock")
public class RuleStockLogicTreeNode implements ILogicTreeNode {

    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {

        return DefaultTreeFactory.TreeActionEntity.builder().ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER).build();
    }
}
