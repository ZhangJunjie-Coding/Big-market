package com.zhang.domain.credit.repository;

import com.zhang.domain.credit.model.aggregate.TradeAggregate;
import com.zhang.domain.credit.model.entity.CreditAccountEntity;

/**
 * @Author: ZhangJunjie
 * @Description: 用户积分仓储
 * @DateTime: 2026/6/25 22:34
 **/
public interface ICreditRepository {

    void saveUserCreditTradeOrder(TradeAggregate tradeAggregate);

    CreditAccountEntity queryUserCreditAccount(String userId);
}
