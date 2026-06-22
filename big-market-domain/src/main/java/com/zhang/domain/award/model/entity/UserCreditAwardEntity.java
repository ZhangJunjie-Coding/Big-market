package com.zhang.domain.award.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: ZhangJunjie
 * @Description: 用户积分奖品实体对象
 * @DateTime: 2026/6/22 16:30
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreditAwardEntity {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 积分值
     */
    private BigDecimal creditAmount;

}
