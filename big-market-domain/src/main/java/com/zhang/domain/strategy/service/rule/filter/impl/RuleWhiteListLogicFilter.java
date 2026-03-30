package com.zhang.domain.strategy.service.rule.filter.impl;

import com.zhang.domain.strategy.model.entity.RuleActionEntity;
import com.zhang.domain.strategy.model.entity.RuleMatterEntity;
import com.zhang.domain.strategy.service.annotation.LogicStrategy;
import com.zhang.domain.strategy.service.rule.filter.ILogicFilter;
import com.zhang.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangJunjie
 * @Description: 白名单过滤规则
 * @DateTime: 2026/3/28 16:54
 **/
@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.RULE_WHITELIST)
public class RuleWhiteListLogicFilter implements ILogicFilter<RuleActionEntity.RaffleBeforeEntity> {

    @Override
    public RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> filter(RuleMatterEntity ruleMatterEntity) {
        return null;
    }
}
