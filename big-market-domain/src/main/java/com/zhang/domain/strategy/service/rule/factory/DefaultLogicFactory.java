package com.zhang.domain.strategy.service.rule.factory;

import com.zhang.domain.strategy.model.entity.RuleActionEntity;
import com.zhang.domain.strategy.service.annotation.LogicStrategy;
import com.zhang.domain.strategy.service.rule.ILogicFilter;
import lombok.*;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: ZhangJunjie
 * @Description: 规则工厂
 * @DateTime: 2026/3/22 11:22
 **/
@Service
public class DefaultLogicFactory {

    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilters.forEach(logic -> {
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_WEIGHT("rule_weight", "【抽奖前规则】根据抽奖权重返回可抽奖范围KEY"),
        RULE_BLACKLIST("rule_blacklist", "【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回"),
        RULE_WHITELIST("rule_whitelist","【抽奖前规则】白名单规则，在白名单范围内的直接中奖一个奖品");

        private final String code;
        private final String info;

    }


}
