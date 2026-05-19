package com.zhang.domain.activity.model.entity;

import lombok.Data;

/**
 * @Author: ZhangJunjie
 * @Description: 参与抽奖活动实体对象
 * @DateTime: 2026/5/18 16:02
 **/
@Data
public class PartakeRaffleActivityEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
