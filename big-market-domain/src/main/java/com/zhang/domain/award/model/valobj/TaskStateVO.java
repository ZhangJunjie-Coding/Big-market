package com.zhang.domain.award.model.valobj;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @Author: ZhangJunjie
 * @Description: 任务状态值对象
 * @DateTime: 2026/5/19 22:03
 **/
@Getter
@AllArgsConstructor
public enum TaskStateVO {

    create("create", "创建"),
    complete("complete", "发送完成"),
    fail("fail", "发送失败"),
    ;

    private final String code;
    private final String desc;

}
