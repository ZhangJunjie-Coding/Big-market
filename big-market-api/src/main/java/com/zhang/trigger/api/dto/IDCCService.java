package com.zhang.trigger.api.dto;

import com.zhang.types.model.Response;

/**
 * @Author: ZhangJunjie
 * @Description: DCC 动态配置中心
 * @DateTime: 2026/7/3 22:42
 **/
public interface IDCCService {
    Response<Boolean> updateConfig(String key, String value);
}
