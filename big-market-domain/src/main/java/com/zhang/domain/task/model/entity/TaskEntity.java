package com.zhang.domain.task.model.entity;

import lombok.Data;

/**
 * @Author: ZhangJunjie
 * @Description: 任务实体对象
 * @DateTime: 2026/5/19 22:29
 **/
@Data
public class TaskEntity {

    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private String message;

}
