package com.zhang.trigger.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: ZhangJunjie
 * @Description: 商品购物车请求对象
 * @DateTime: 2026/6/28 21:53
 **/
@Data
public class SkuProductShopCartRequestDTO implements Serializable {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * sku 商品
     */
    private Long sku;

}
