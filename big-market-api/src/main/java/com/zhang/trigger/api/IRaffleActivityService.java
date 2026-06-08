package com.zhang.trigger.api;

import com.zhang.trigger.api.dto.ActivityDrawRequestDTO;
import com.zhang.trigger.api.dto.ActivityDrawResponseDTO;
import com.zhang.types.model.Response;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖活动服务
 * @DateTime: 2026/6/8 9:49
 **/
public interface IRaffleActivityService {
    /**
     * 活动装配，数据预热缓存
     * @param activityId 活动ID
     * @return 装配结果
     */
    Response<Boolean> armory(Long activityId);

    /**
     * 活动抽奖接口
     * @param request 请求对象
     * @return 返回结果
     */
    Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request);
}
