package com.zhang.domain.task.repository;

import com.zhang.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/5/19 22:30
 **/
public interface ITaskRepository {

    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId, String messageId);

    void updateTaskSendMessageFail(String userId, String messageId);


}
