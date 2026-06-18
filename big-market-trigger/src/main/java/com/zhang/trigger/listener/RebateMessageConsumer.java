package com.zhang.trigger.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zhang.domain.activity.model.entity.SkuRechargeEntity;
import com.zhang.domain.activity.service.IRaffleActivityAccountQuotaService;
import com.zhang.domain.rebate.event.SendRebateMessageEvent;
import com.zhang.domain.rebate.model.valobj.RebateTypeVO;
import com.zhang.types.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @Author: ZhangJunjie
 * @Description: 监听：行为返利消息
 * @DateTime: 2026/6/17 17:43
 **/
@Slf4j
@Component
public class RebateMessageConsumer {

    @Value("${spring.rabbitmq.topic.send_rebate}")
    private String topic;

    @Resource
    private IRaffleActivityAccountQuotaService raffleActivityAccountQuotaService;


    @RabbitListener(queuesToDeclare = @Queue(value = "send_rebate"))
    public void listener(String message) {
        try {
            log.info("监听用户行为返利消息  topic:{}, message:{}", topic, message);
            // 1. 转换消息

            BaseEvent.EventMessage<SendRebateMessageEvent.RebateMessage> eventMessage = JSON.parseObject(message,
                    new TypeReference<BaseEvent.EventMessage<SendRebateMessageEvent.RebateMessage>>() {
                    }.getType());
            SendRebateMessageEvent.RebateMessage rebateMessage = eventMessage.getData();
            if (!RebateTypeVO.SKU.getCode().equals(rebateMessage.getRebateType())) {
                log.info("监听用户行为返利消息 - 非sku奖励暂时不处理  topic:{}, message:{}", topic, message);
                return;
            }

            // 2. 入账奖励
            SkuRechargeEntity skuRechargeEntity = new SkuRechargeEntity();
            skuRechargeEntity.setUserId(rebateMessage.getUserId());
            skuRechargeEntity.setSku(Long.valueOf(rebateMessage.getRebateConfig()));
            skuRechargeEntity.setOutBusinessNo(rebateMessage.getBizId());
            raffleActivityAccountQuotaService.createOrder(skuRechargeEntity);



        } catch (Exception e) {
            log.error("监听用户行为返利消息，消费失败 topic: {} message: {}", topic, message, e);
            throw e;
        }

    }
}
