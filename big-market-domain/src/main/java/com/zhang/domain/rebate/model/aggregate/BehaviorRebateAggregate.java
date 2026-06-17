package com.zhang.domain.rebate.model.aggregate;

import com.zhang.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import com.zhang.domain.rebate.model.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author: ZhangJunjie
 * @Description: 行为返利聚合对象
 * @DateTime: 2026/6/16 22:20
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BehaviorRebateAggregate {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 行为返利订单实体对象
     */
    private BehaviorRebateOrderEntity behaviorRebateOrderEntity;
    /**
     * 任务实体对象
     */
    private TaskEntity taskEntity;

}
