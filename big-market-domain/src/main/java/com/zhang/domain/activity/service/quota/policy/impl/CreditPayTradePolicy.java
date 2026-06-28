package com.zhang.domain.activity.service.quota.policy.impl;

import com.zhang.domain.activity.model.aggregate.CreateQuotaOrderAggregate;
import com.zhang.domain.activity.model.valobj.OrderStateVO;
import com.zhang.domain.activity.repository.IActivityRepository;
import com.zhang.domain.activity.service.quota.policy.ITradePolicy;
import org.springframework.stereotype.Service;

/**
 * @Author: ZhangJunjie
 * @Description: 积分兑换，支付类订单
 * @DateTime: 2026/6/28 17:02
 **/
@Service("credit_pay_trade")
public class CreditPayTradePolicy implements ITradePolicy {

    private final IActivityRepository activityRepository;

    public CreditPayTradePolicy(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void trade(CreateQuotaOrderAggregate createQuotaOrderAggregate) {
        createQuotaOrderAggregate.setOrderState(OrderStateVO.wait_pay);
        activityRepository.doSaveCreditPayOrder(createQuotaOrderAggregate);
    }

}
