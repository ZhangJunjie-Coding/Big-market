package com.zhang.domain.strategy.service;

import com.zhang.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 策略奖品接口
 * @DateTime: 2026/4/11 17:38
 **/
public interface IRaffleAward {

    /**
     * 根据策略ID查询抽奖奖品列表配置
     *
     * @param strategyId 策略ID
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);

}
