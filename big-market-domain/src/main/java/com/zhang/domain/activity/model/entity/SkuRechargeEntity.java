package com.zhang.domain.activity.model.entity;

import com.zhang.domain.activity.model.valobj.OrderTradeTypeVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ZhangJunjie
 * @Description: 活动商品充值实体对象
 * @DateTime: 2026/5/17 11:22
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkuRechargeEntity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 商品SKU - activity + activity count
     */
    private Long sku;
    /**
     * 幂等业务单号，外部谁充值谁透传，这样来保证幂等（多次调用也能确保结果唯一，不会多次充值）。
     */
    private String outBusinessNo;
    /**
     * 用户ID
     */
    private OrderTradeTypeVO orderTradeType = OrderTradeTypeVO.rebate_no_pay_trade;
}
