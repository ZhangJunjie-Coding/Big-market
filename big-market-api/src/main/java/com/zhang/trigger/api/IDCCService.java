package com.zhang.trigger.api;

import com.zhang.types.model.Response;

/**
 * @Author: ZhangJunjie
 * @Description:
 * @DateTime: 2026/7/4 21:12
 **/
public interface IDCCService {
    Response<Boolean> updateConfig(String key, String value);
}
