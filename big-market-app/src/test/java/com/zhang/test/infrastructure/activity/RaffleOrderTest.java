package com.zhang.test.infrastructure.activity;

import com.alibaba.fastjson.JSON;
import com.zhang.domain.activity.model.entity.ActivityOrderEntity;
import com.zhang.domain.activity.model.entity.ActivityShopCartEntity;
import com.zhang.domain.activity.model.entity.SkuRechargeEntity;
import com.zhang.domain.activity.service.IRaffleOrder;
import com.zhang.domain.support.id.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.common.value.qual.StringVal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/5/16 22:33
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleOrderTest {

    @Resource
    private IRaffleOrder raffleOrder;

    @Resource
    private IIdGenerator iIdGenerator;

    @Test
    public void test_createRaffleActivityOrder() {
        ActivityShopCartEntity activityShopCartEntity = new ActivityShopCartEntity();
        activityShopCartEntity.setUserId("xiaofuge");
        activityShopCartEntity.setSku(9011L);
        ActivityOrderEntity raffleActivityOrder = raffleOrder.createRaffleActivityOrder(activityShopCartEntity);
        log.info("测试结果：{}", JSON.toJSONString(raffleActivityOrder));
    }

    @Test
    public void test_createSkuRechargeOrder() {
        SkuRechargeEntity skuRechargeEntity = new SkuRechargeEntity();
        skuRechargeEntity.setUserId("zjj");
        skuRechargeEntity.setSku(9011L);
        skuRechargeEntity.setOutBusinessNo(String.valueOf(iIdGenerator.nextId()));
        String orderId = raffleOrder.createSkuRechargeOrder(skuRechargeEntity);
        log.info("skuRechargeEntity: {}", JSON.toJSONString(skuRechargeEntity));
        log.info("测试结果:{}", orderId);
    }
}
