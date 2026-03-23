package com.zhang.domain.strategy.service.rule;

import com.zhang.domain.strategy.model.entity.RaffleAwardEntity;
import com.zhang.domain.strategy.model.entity.RuleActionEntity;
import com.zhang.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖规则过滤接口
 * @DateTime: 2026/3/22 11:23
 **/
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {
    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
}
