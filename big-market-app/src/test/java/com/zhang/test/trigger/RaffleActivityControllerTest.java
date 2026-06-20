package com.zhang.test.trigger;

import com.alibaba.fastjson.JSON;
import com.zhang.trigger.api.IRaffleActivityService;
import com.zhang.trigger.api.dto.ActivityDrawRequestDTO;
import com.zhang.trigger.api.dto.ActivityDrawResponseDTO;
import com.zhang.trigger.api.dto.UserActivityAccountRequestDTO;
import com.zhang.trigger.api.dto.UserActivityAccountResponseDTO;
import com.zhang.types.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityControllerTest {

    @Resource
    private IRaffleActivityService raffleActivityService;

    @Test
    public void test_armory() {
        Response<Boolean> response = raffleActivityService.armory(100301L);
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_draw() {
        ActivityDrawRequestDTO request = new ActivityDrawRequestDTO();
        request.setActivityId(100301L);
        request.setUserId("xiaofuge");
        Response<ActivityDrawResponseDTO> response = raffleActivityService.draw(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }



    @Test
    public void test_calendarSignRebate() {
        Response<Boolean> response = raffleActivityService.calendarSignRebate("xiaofuge");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_isCalendarSignRebate() {
        Response<Boolean> response = raffleActivityService.isCalendarSignRebate("xiaofuge");
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

    @Test
    public void test_queryUserActivityAccount() {
        UserActivityAccountRequestDTO request = new UserActivityAccountRequestDTO();
        request.setActivityId(100301L);
        request.setUserId("xiaofuge");

        // 查询数据
        Response<UserActivityAccountResponseDTO> response = raffleActivityService.queryUserActivityAccount(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }



}