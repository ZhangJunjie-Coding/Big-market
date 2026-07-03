package com.zhang.trigger.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ZhangJunjie
 * @Description: 活动抽奖请求对象
 * @DateTime: 2026/6/8 9:50
 **/
@Data
public class ActivityDrawRequestDTO implements Serializable {    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
