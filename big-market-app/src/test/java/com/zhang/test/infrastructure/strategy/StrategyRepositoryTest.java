package com.zhang.test.infrastructure.strategy;

import com.alibaba.fastjson.JSON;
import com.zhang.domain.strategy.model.valobj.RuleTreeVO;
import com.zhang.domain.strategy.repository.IStrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: ZhangJunjie
 * @Description: 仓储数据查询
 * @DateTime: 2026/4/5 22:42
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyRepositoryTest {
    @Resource
    private IStrategyRepository strategyRepository;

    @Test
    public void queryRuleTreeVOByTreeId() {
        RuleTreeVO ruleTreeVO = strategyRepository.queryRuleTreeVOByTreeId("tree_lock");
        log.info("测试结果: {}", JSON.toJSONString(ruleTreeVO));



    }

}
