package com.zhang.test.domain;

import com.zhang.domain.strategy.service.armory.IStrategyArmory;
import com.zhang.domain.strategy.service.armory.IStrategyDispatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/3/21 18:07
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {

    @Resource
    private IStrategyArmory strategyArmory;

    @Resource
    private IStrategyDispatch strategyDispatch;

    @Before
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100001l);
        log.info("测试结果: {}", success);
    }


    /**
     * 从装配的策略中随机获取奖品ID值
     */
    @Test
    public void test_getRandomAwardId() {
        log.info("测试结果: {} - 奖品ID值", strategyDispatch.getRandomAwardId(100001l));
    }

    @Test
    public void test_getRandomAwardId_ruleWeightValue() {
        log.info("测试结果: {} - 4000策略配置", strategyDispatch.getRandomAwardId(100001l, "4000:102,103,104,105"));
        log.info("测试结果: {} - 5000策略配置", strategyDispatch.getRandomAwardId(100001l, "5000:102,103,104,105,106,107"));
        log.info("测试结果: {} - 6000策略配置", strategyDispatch.getRandomAwardId(100001l, "6000:102,103,104,105,106,107,108,109"));
    }
}
