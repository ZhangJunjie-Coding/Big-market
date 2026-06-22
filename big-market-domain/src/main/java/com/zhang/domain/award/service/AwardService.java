package com.zhang.domain.award.service;

import com.zhang.domain.award.event.SendAwardMessageEvent;
import com.zhang.domain.award.model.aggregate.UserAwardRecordAggregate;
import com.zhang.domain.award.model.entity.DistributeAwardEntity;
import com.zhang.domain.award.model.entity.TaskEntity;
import com.zhang.domain.award.model.entity.UserAwardRecordEntity;
import com.zhang.domain.award.model.valobj.TaskStateVO;
import com.zhang.domain.award.repository.IAwardRepository;
import com.zhang.domain.award.service.distribute.IDistributeAward;
import com.zhang.types.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: ZhangJunjie
 * @Description: 奖品服务
 * @DateTime: 2026/5/19 21:59
 **/
@Slf4j
@Service
public class AwardService implements IAwardService {

//    @Resource
//    private IAwardRepository awardRepository;
//    @Resource
//    private SendAwardMessageEvent sendAwardMessageEvent;
//    @Resource
//    private Map<String, IDistributeAward> distributeAwardMap;

    private final IAwardRepository awardRepository;
    private final SendAwardMessageEvent sendAwardMessageEvent;
    private final Map<String, IDistributeAward> distributeAwardMap;

    public AwardService(IAwardRepository awardRepository, SendAwardMessageEvent sendAwardMessageEvent, Map<String, IDistributeAward> distributeAwardMap) {
        this.awardRepository = awardRepository;
        this.sendAwardMessageEvent = sendAwardMessageEvent;
        this.distributeAwardMap = distributeAwardMap;
    }

    @Override
    public void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity) {
        // 构建消息对象
        SendAwardMessageEvent.SendAwardMessage sendAwardMessage = new SendAwardMessageEvent.SendAwardMessage();
        sendAwardMessage.setUserId(userAwardRecordEntity.getUserId());
        sendAwardMessage.setOrderId(userAwardRecordEntity.getOrderId());
        sendAwardMessage.setAwardId(userAwardRecordEntity.getAwardId());
        sendAwardMessage.setAwardTitle(userAwardRecordEntity.getAwardTitle());
        sendAwardMessage.setAwardConfig(userAwardRecordEntity.getAwardConfig());

        BaseEvent.EventMessage<SendAwardMessageEvent
                .SendAwardMessage> sendAwardMessageEventMessage = sendAwardMessageEvent.buildEventMessage(sendAwardMessage);

        // 构建任务对象
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setUserId(userAwardRecordEntity.getUserId());
        taskEntity.setTopic(sendAwardMessageEvent.topic());
        taskEntity.setMessageId(sendAwardMessageEventMessage.getId());
        taskEntity.setMessage(sendAwardMessageEventMessage);
        taskEntity.setState(TaskStateVO.create);

        // 构建聚合对象
        UserAwardRecordAggregate userAwardRecordAggregate = UserAwardRecordAggregate.builder()
                .taskEntity(taskEntity)
                .userAwardRecordEntity(userAwardRecordEntity)
                .build();

        // 存储聚合对象 - 一个事务下，用户的中奖记录
        awardRepository.saveUserAwardRecord(userAwardRecordAggregate);
    }

    @Override
    public void distributeAward(DistributeAwardEntity distributeAwardEntity) {
        // 奖品Key
        String awardKey = awardRepository.queryAwardKey(distributeAwardEntity.getAwardId());
        if (null == awardKey) {
            log.error("分发奖品，奖品ID不存在。awardKey:{}", awardKey);
            return;
        }
        // 奖品服务
        IDistributeAward distributeAward = distributeAwardMap.get(awardKey);
        if (null == distributeAward) {
            log.error("分发奖品，对应的服务不存在。awardKey:{}", awardKey);
            // todo 后续完善全部奖品后开启异常
//            throw new RuntimeException("分发奖品，奖品" + awardKey + "对应的服务不存在");
            return;
        }
        // 发放奖品
        distributeAward.giveOutPrizes(distributeAwardEntity);
    }
}
