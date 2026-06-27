package com.zhang.test.rebate;

import com.alibaba.fastjson.JSON;
import com.zhang.domain.activity.service.armory.IActivityArmory;
import com.zhang.domain.rebate.model.entity.BehaviorEntity;
import com.zhang.domain.rebate.model.valobj.BehaviorTypeVO;
import com.zhang.domain.rebate.service.IBehaviorRebateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: ZhangJunjie
 * @Description: 行为返利单测
 * @DateTime: 2026/6/16 22:51
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BehaviorRebateServiceTest {

    @Resource
    private IBehaviorRebateService behaviorRebateService;

    @Resource
    private IActivityArmory activityArmory;

    @Before
    public void setUp() {
        log.info("装配活动:{}", activityArmory.assembleActivitySku(9011L));
    }
    @Test
    public void test_createOrder() throws InterruptedException {
        BehaviorEntity behaviorEntity = new BehaviorEntity();
        behaviorEntity.setUserId("xiaofuge");
        behaviorEntity.setBehaviorTypeVO(BehaviorTypeVO.SIGN);
        // 重复的 OutBusinessNo 会报错唯一索引冲突，这也是保证幂等的手段，确保不会多记账
        behaviorEntity.setOutBusinessNo("2024023503");

        List<String> orderIds = behaviorRebateService.createOrder(behaviorEntity);
        log.info("请求参数：{}", JSON.toJSONString(behaviorEntity));
        log.info("测试结果：{}", JSON.toJSONString(orderIds));

        new CountDownLatch(1).await();
    }

}
