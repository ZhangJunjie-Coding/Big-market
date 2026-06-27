package com.zhang.domain.credit.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: ZhangJunjie
 * @Description: 交易名称枚举值
 * @DateTime: 2026/6/23 15:52
 **/
@Getter
@AllArgsConstructor
public enum TradeNameVO {

    REBATE("行为返利"),
    CONVERT_SKU("兑换抽奖"),

    ;

    private final String name;

}
