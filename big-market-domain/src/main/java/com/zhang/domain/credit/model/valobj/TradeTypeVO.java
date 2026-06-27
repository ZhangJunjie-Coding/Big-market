package com.zhang.domain.credit.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: ZhangJunjie
 * @Description: 交易类型枚举值
 * @DateTime: 2026/6/23 15:52
 **/
@Getter
@AllArgsConstructor
public enum TradeTypeVO {

    FORWARD("forward", "正向交易，+ 积分"),
    REVERSE("reverse", "逆向交易，- 积分"),
    ;

    private final String code;
    private final String info;

}
