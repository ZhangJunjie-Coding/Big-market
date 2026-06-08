package com.zhang.domain.strategy.service.rule.tree.impl;

import com.zhang.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.zhang.domain.strategy.repository.IStrategyRepository;
import com.zhang.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.zhang.domain.strategy.service.rule.tree.fatory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Author: ZhangJunjie
 * @Description: 次数锁节点
 * @DateTime: 2026/3/30 15:23
 **/
@Slf4j
@Component("rule_lock")
public class RuleLockLogicTreeNode implements ILogicTreeNode {

    @Resource
    private IStrategyRepository repository;


    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue) {
        log.info("规则过滤-次数锁 userId:{} strategyId:{} awardId:{}", userId, strategyId, awardId);

        long raffleCount = 0L;
        try {
            raffleCount = Long.parseLong(ruleValue);
        } catch (Exception e) {
            throw new RuntimeException("规则过滤-次数锁异常 ruleValue: " + ruleValue + " 配置不正确");
        }

        // 查询用户抽奖次数,当前的: 策略ID:活动ID 1:1的配置，可以直接用strategyId查询
        Integer userRaffleCount = repository.queryTodayUserRaffleCount(userId, strategyId);

        // 用户抽奖，次数大于规则限定值规则放行
        if (userRaffleCount >= raffleCount) {
            log.info("规则过滤-次数锁 【放行】 userId:{} strategyId:{} awardId: {},raffleCount:{} userRaffleCount: {}",
                    userId, strategyId, awardId, raffleCount, userRaffleCount);
            return DefaultTreeFactory.TreeActionEntity.builder()
                    .ruleLogicCheckType(RuleLogicCheckTypeVO.ALLOW)
                    .build();
        }
        log.info("规则过滤-次数锁 【拦截】 userId:{} strategyId:{} awardId: {},raffleCount:{} userRaffleCount: {}",
                userId, strategyId, awardId, raffleCount, userRaffleCount);
        // 用户抽奖次数小于规则限定值，规则拦截
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .build();
    }
}
