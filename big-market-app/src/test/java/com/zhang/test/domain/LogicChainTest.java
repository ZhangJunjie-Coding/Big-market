package com.zhang.test.domain;

import com.zhang.domain.strategy.service.rule.chain.ILogicChain;
import com.zhang.domain.strategy.service.rule.chain.facotry.DefaultChainFactory;
import com.zhang.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;


/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/3/29 21:58
 **/
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogicChainTest {

    @Resource
    private DefaultChainFactory defaultChainFactory;

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;

    @Test
    public void test_LogicChain_rule_blacklist() {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        Integer awardId = logicChain.logic("user001", 100001L);
        log.info("测试结果：{}", awardId);
    }

    @Test
    public void test_LogicChain_rule_weight() {
        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 4900L);
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        Integer awardId = logicChain.logic("xiaofuge", 100001L);
        log.info("测试结果：{}", awardId);
    }

    @Test
    public void test_LogicChain_rule_default() {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(100001L);
        Integer awardId = logicChain.logic("xiaofuge", 100001L);
        log.info("测试结果：{}", awardId);
    }
}
