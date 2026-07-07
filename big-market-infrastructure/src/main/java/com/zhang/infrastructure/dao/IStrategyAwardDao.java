package com.zhang.infrastructure.dao;

import com.zhang.infrastructure.dao.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖策略奖品明细配置-概率、规则 DAO
 * @DateTime: 2026/3/19 15:04
 **/
@Mapper
public interface IStrategyAwardDao {

    List<StrategyAward> queryStrategyAwardList();

    List<StrategyAward> queryStrategyAwardListByStrategyId(Long strategyId);

    String queryStrategyAwardRuleModels(StrategyAward strategyAward);

    void updateStrategyAwardStock(StrategyAward strategyAward);

    StrategyAward queryStrategyAward(StrategyAward strategyAwardReq);

    List<StrategyAward> queryOpenActivityStrategyAwardList();
}
