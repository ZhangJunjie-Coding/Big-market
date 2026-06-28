package com.zhang.domain.activity.service.quota.policy;

import com.zhang.domain.activity.model.aggregate.CreateQuotaOrderAggregate;

/**
 * @Author: ZhangJunjie
 * @Description: 交易策略接口，包括；返利兑换（不用支付），积分订单（需要支付）
 * @DateTime: 2026/6/28 16:59
 **/
public interface ITradePolicy {
    void trade(CreateQuotaOrderAggregate createQuotaOrderAggregate);
}
