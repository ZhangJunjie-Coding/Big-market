package com.zhang.domain.credit.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: ZhangJunjie
 * @Description: 积分账户实体
 * @DateTime: 2026/6/23 15:51
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditAccountEntity {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 可用积分，每次扣减的值
     */
    private BigDecimal adjustAmount;

}
