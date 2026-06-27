package com.zhang.domain.credit.service;

import com.zhang.domain.credit.model.entity.TradeEntity;

/**
 * @Author: ZhangJunjie
 * @Description: 积分调额接口【正逆向，增减积分】
 * @DateTime: 2026/6/25 22:39
 **/
public interface ICreditAdjustService {

    /**
     * 创建增加积分额度订单
     * @param tradeEntity 交易实体对象
     * @return 单号
     */
    String createOrder(TradeEntity tradeEntity);

}
