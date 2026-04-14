package com.zhang.types.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: ZhangJunjie
 * @Description: Response
 * @DateTime: 2026/4/11 15:27
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {
    private String code;
    private String info;
    private T data;
}
