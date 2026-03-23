package com.zhang.infrastructure.persistent.dao;

import com.zhang.infrastructure.persistent.po.Strategy;
import com.zhang.infrastructure.persistent.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 策略规则 DAO
 * @DateTime: 2026/3/19 15:04
 **/
@Mapper
public interface IStrategyRuleDao {
    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);

    String queryStrategyRuleValue(StrategyRule strategyRule);
}
