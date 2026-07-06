package com.zhang.test;

import com.zhang.domain.support.id.IIdGenerator;
import com.zhang.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Resource
    IRedisService redisService;


    @Resource
    IIdGenerator snowflakeIdWorker;


    @Test
    public void testIdGeneration() {
        for (int i = 0; i < 5; i++) {
            System.out.println(snowflakeIdWorker.nextId());
        }
    }

    @Test
    public void test() {
        log.info("测试完成");
    }

    @Test
    public void test01() {
        RMap<Object, Object> map = redisService.getMap("strategy_id_100002");
        map.put(1, 101);
        map.put(2, 101);
        map.put(3, 101);
        map.put(4, 102);
        map.put(5, 102);
        map.put(6, 102);
        map.put(7, 103);
        map.put(8, 103);
        map.put(9, 104);
        map.put(10, 105);
        log.info("测试结果: {}", redisService.getFromMap("strategy_id_100002", 1).toString());

    }

    @Test
    public void test02() {
        int number = 1;
        System.out.println(number << 30);
    }

}