package com.zhang.types.annotations;


import java.lang.annotation.*;

/**
 * @Author: ZhangJunjie
 * @Description: 注解，动态配置中心
 * @DateTime: 2026/7/4 8:53
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface DCCValue {
    String value() default "";
}
