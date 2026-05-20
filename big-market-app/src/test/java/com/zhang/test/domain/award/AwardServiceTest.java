package com.zhang.test.domain.award;

import com.zhang.domain.award.model.entity.UserAwardRecordEntity;
import com.zhang.domain.award.model.valobj.AwardStateVO;
import com.zhang.domain.award.repository.IAwardRepository;
import com.zhang.domain.award.service.IAwardService;
import com.zhang.domain.support.id.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: ZhangJunjie
 * @Description: 奖品服务测试
 * @DateTime: 2026/5/19 22:48
 **/
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AwardServiceTest {

    @Resource
    private IAwardService awardService;

    @Resource
    private IIdGenerator iIdGenerator;
    /**
     * 模拟发放抽奖记录，流程中会发送MQ，以及接收MQ消息，还有 task 表，补偿发送MQ
     */
    @Test
    public void test_saveUserAwardRecord() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            UserAwardRecordEntity userAwardRecordEntity = new UserAwardRecordEntity();
            userAwardRecordEntity.setUserId("xiaofuge");
            userAwardRecordEntity.setActivityId(100301L);
            userAwardRecordEntity.setStrategyId(100006L);
            userAwardRecordEntity.setOrderId(String.valueOf(iIdGenerator.nextId()));
            userAwardRecordEntity.setAwardId(101);
            userAwardRecordEntity.setAwardTitle("OpenAI 增加使用次数");
            userAwardRecordEntity.setAwardTime(new Date());
            userAwardRecordEntity.setAwardState(AwardStateVO.create);
            awardService.saveUserAwardRecord(userAwardRecordEntity);
            Thread.sleep(500);
        }

        new CountDownLatch(1).await();
    }


}
