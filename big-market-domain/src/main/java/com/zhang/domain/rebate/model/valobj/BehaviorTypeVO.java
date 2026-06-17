package com.zhang.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: ZhangJunjie
 * @Description: 行为类型枚举值对象
 * @DateTime: 2026/6/16 22:20
 **/
@Getter
@AllArgsConstructor
public enum BehaviorTypeVO {

    SIGN("sign", "签到（日历）"),
    OPENAI_PAY("openai_pay", "openai 外部支付完成"),
    ;

    private final String code;
    private final String info;

}
