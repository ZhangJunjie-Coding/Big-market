package com.zhang.test.domain.activity;

import com.zhang.domain.activity.model.entity.SkuRechargeEntity;
import com.zhang.domain.activity.service.IRaffleActivityAccountQuotaService;
import com.zhang.domain.activity.service.IRaffleActivitySkuStockService;
import com.zhang.domain.activity.service.armory.IActivityArmory;
import com.zhang.domain.support.id.IIdGenerator;
import com.zhang.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: ZhangJunjie
 * @Description:  抽奖活动参与服务测试
 * @DateTime: 2026/5/19 10:18
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityAccountQuotaServiceTest {

    @Resource
    private IIdGenerator iIdGenerator;
    @Resource
    private IRaffleActivityAccountQuotaService raffleActivityAccountQuotaService;

    @Resource
    private IRaffleActivitySkuStockService skuStock;

    @Resource
    private IActivityArmory activityArmory;

    @Before
    public void setUp() {
        log.info("装配活动：{}", activityArmory.assembleActivitySku(9011L));
    }

    @Test
    public void test_createSkuRechargeOrder_duplicate() {
        SkuRechargeEntity skuRechargeEntity = new SkuRechargeEntity();
        skuRechargeEntity.setUserId("zjj");
        skuRechargeEntity.setSku(9011L);
        // outBusinessNo 作为幂等仿重使用，同一个业务单号2次使用会抛出索引冲突 Duplicate entry '700091009111' for key 'uq_out_business_no' 确保唯一性。
        skuRechargeEntity.setOutBusinessNo("700091009119");
        String orderId = raffleActivityAccountQuotaService.createOrder(skuRechargeEntity);
        log.info("测试结果：{}", orderId);
    }

    /**
     * 测试库存消耗和最终一致更新
     * 1. raffle_activity_sku 库表库存可以设置20个
     * 2. 清空 redis 缓存 flushall
     * 3. for 循环20次，消耗完库存，最终数据库剩余库存为0
     */
    @Test
    public void test_createSkuRechargeOrder() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            try {
                SkuRechargeEntity skuRechargeEntity = new SkuRechargeEntity();
                skuRechargeEntity.setUserId("zjj");
                skuRechargeEntity.setSku(9011L);
                // outBusinessNo 作为幂等仿重使用，同一个业务单号2次使用会抛出索引冲突 Duplicate entry '700091009111' for key 'uq_out_business_no' 确保唯一性。
                skuRechargeEntity.setOutBusinessNo(RandomStringUtils.randomNumeric(12));
                String orderId = raffleActivityAccountQuotaService.createOrder(skuRechargeEntity);
                log.info("测试结果：{}", orderId);
            } catch (AppException e) {
                log.warn(e.getInfo());
            }
        }

        new CountDownLatch(1).await();
    }


    /**
     * 测试归零标记：标记后 isActivitySkuStockZero 返回 true
     */
    @Test
    public void test_markActivitySkuStockZero() {
        Long testSku = 9999L;

        // 标记前：应该返回 false
        boolean before = skuStock.isActivitySkuStockZero(testSku);
        log.info("标记前 sku:{} 是否已归零: {}", testSku, before);
        assert !before;

        // 标记
        skuStock.markActivitySkuStockZero(testSku);

        // 标记后：应该返回 true
        boolean after = skuStock.isActivitySkuStockZero(testSku);
        log.info("标记后 sku:{} 是否已归零: {}", testSku, after);
        assert after;
    }

    /**
     * 测试未标记的 SKU 不受影响
     */
    @Test
    public void test_isActivitySkuStockZero_notMarked() {
        Long testSku = 8888L;

        // 从未标记过的 SKU 应该返回 false
        boolean result = skuStock.isActivitySkuStockZero(testSku);
        log.info("未标记的 sku:{} 是否已归零: {}", testSku, result);
        assert !result;
    }



}
