package com.zhang.domain.strategy.repository;

import com.zhang.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhang.domain.strategy.model.entity.StrategyEntity;
import com.zhang.domain.strategy.model.entity.StrategyRuleEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 策略仓储接口
 * @DateTime: 2026/3/19 21:07
 **/
public interface IStrategyRepository {
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    <K, V> void storeStrategyAwardSearchRateTable(String key, Integer rateRange, HashMap<K, V> shuffleStrategyAwardSearchRateTables);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, int rateKey);


    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);
}
