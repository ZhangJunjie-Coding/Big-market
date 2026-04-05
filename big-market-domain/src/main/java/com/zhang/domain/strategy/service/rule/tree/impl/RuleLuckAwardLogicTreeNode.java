package com.zhang.domain.strategy.service.rule.tree.impl;

import com.zhang.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.zhang.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.zhang.domain.strategy.service.rule.tree.fatory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @Author: ZhangJunjie
 * @Description: 兜底奖励节点
 * @DateTime: 2026/3/30 15:56
 **/
@Slf4j
@Component("rule_luck_award")
public class RuleLuckAwardLogicTreeNode implements ILogicTreeNode {

    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .strategyAwardData(DefaultTreeFactory.StrategyAwardData.builder()
                        .awardId(101)
                        .awardRuleValue("1,100")
                        .build())
                .build();
    }
}
