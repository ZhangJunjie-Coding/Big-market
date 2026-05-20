package com.zhang.domain.award.model.aggregate;

import com.zhang.domain.award.model.entity.TaskEntity;
import com.zhang.domain.award.model.entity.UserAwardRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ZhangJunjie
 * @Description: 用户中奖记录聚合对象 【聚合代表一个事务操作】
 * @DateTime: 2026/5/19 22:04
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAwardRecordAggregate {

    private UserAwardRecordEntity userAwardRecordEntity;

    private TaskEntity taskEntity;

}
