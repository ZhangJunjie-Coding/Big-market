package com.zhang.domain.award.model.entity;

import com.zhang.domain.award.event.SendAwardMessageEvent;
import com.zhang.domain.award.model.valobj.TaskStateVO;
import com.zhang.types.event.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ZhangJunjie
 * @Description: 任务实体对象
 * @DateTime: 2026/5/19 22:01
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    /**
     * 活动ID
     */
    private String userId;
    /**
     * 消息主题
     */
    private String topic;
    /**
     * 消息编号
     */
    private String messageId;
    /**
     * 消息主体
     */
    private BaseEvent.EventMessage<SendAwardMessageEvent.SendAwardMessage> message;
    /**
     * 任务状态；create-创建、completed-完成、fail-失败
     */
    private TaskStateVO state;

}
