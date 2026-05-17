package com.zhang.test.infrastructure.strategy;

import com.alibaba.fastjson.JSON;
import com.zhang.infrastructure.persistent.dao.IRaffleActivityDao;
import com.zhang.infrastructure.persistent.po.RaffleActivity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖活动配置Dao测试
 * @DateTime: 2026/5/16 19:35
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityDaoTest {

    @Resource
    private IRaffleActivityDao raffleActivityDao;

    @Test
    public void testQueryRaffleActivityByActivityId() {

        RaffleActivity raffleActivity = raffleActivityDao.queryRaffleActivityByActivityId(100301l);
        log.info("raffleActivity: {}", JSON.toJSONString(raffleActivity));


    }
}
