package com.zhang.domain.award.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: ZhangJunjie
 * @Description: 账户状态枚举
 * @DateTime: 2026/6/22 17:56
 **/
@Getter
@AllArgsConstructor
public enum AccountStatusVO {

    open("open", "开启"),
    close("close", "冻结"),
    ;

    private final String code;
    private final String desc;

}
