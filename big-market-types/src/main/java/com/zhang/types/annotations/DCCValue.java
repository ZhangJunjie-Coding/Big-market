package com.zhang.types.annotations;

import com.sun.istack.internal.Interned;

import java.lang.annotation.*;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/7/4 8:53
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface DCCValue {
    String value() default "";
}
