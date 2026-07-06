package com.zhang.test.domain.strategy;

import com.zhang.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/3/23 20:40
 **/
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisViewTest {


    @Resource
    IRedisService redisService;

    @Test
    public void test01() {
        String key = "big_market_strategy_rate_range_key_100001";
        System.out.println(redisService.<Integer>getValue(key));
    }

    @Test
    public void test02() {
        String key = "big_market_strategy_rate_range_key_100001";
        System.out.println(redisService.<Integer>getValue(key));
    }

    @Test
    public void test03() {
        int range = 10;
        for (int i =0;i<200;i++){
            System.out.println(new SecureRandom().nextInt(range));
        }
    }

    @Test
    public void test04(){
        String key = "big_market_strategy_rate_range_key_100001_4000:102,103,104,105";
        System.out.println(redisService.<Integer>getValue(key));
    }
}
