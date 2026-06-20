package com.zhang.trigger.api.dto;

import lombok.Data;

/**
 * @Author: ZhangJunjie
 * @Description: 用户活动账户请求对象
 * @DateTime: 2026/6/19 22:30
 **/
@Data
public class UserActivityAccountRequestDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
