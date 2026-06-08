package com.zhang.trigger.api.dto;

import lombok.Data;

/**
 * @Author: ZhangJunjie
 * @Description: 活动抽奖请求对象
 * @DateTime: 2026/6/8 9:50
 **/
@Data
public class ActivityDrawRequestDTO {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
