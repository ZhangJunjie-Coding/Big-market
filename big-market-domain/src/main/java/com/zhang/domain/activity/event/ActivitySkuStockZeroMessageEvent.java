package com.zhang.domain.activity.event;

import com.zhang.domain.support.id.IIdGenerator;
import com.zhang.types.event.BaseEvent;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: ZhangJunjie
 * @Description: 活动sku库存清空消息
 * @DateTime: 2026/5/17 22:33
 **/
@Component
public class ActivitySkuStockZeroMessageEvent extends BaseEvent<Long> {
    @Autowired
    private IIdGenerator iIdGenerator;

    @Value("${spring.rabbitmq.topic.activity_sku_stock_zero}")
    private String topic;

    @Override
    public EventMessage<Long> buildEventMessage(Long sku) {
        return EventMessage.<Long>builder()
                .id(String.valueOf(iIdGenerator.nextId()))
                .timestamp(new Date())
                .data(sku)
                .build();
    }

    @Override
    public String topic() {
        return topic;
    }

}
