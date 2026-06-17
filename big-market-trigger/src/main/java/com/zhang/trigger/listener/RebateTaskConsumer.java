package com.zhang.trigger.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: ZhangJunjie
 * @Description:
 * @DateTime: 2026/6/17 17:43
 **/
@Slf4j
@Component
public class RebateTaskConsumer {

    @Value("${spring.rabbitmq.topic.send_rebate}")
    private String topic;


    @RabbitListener(queuesToDeclare = @Queue(value = "send_rebate"))
    public void listener(String message) {
        log.info("监听xxx  topic:{}, message:{}", topic, message);


    }
}
