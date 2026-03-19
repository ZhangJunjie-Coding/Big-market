package com.zhang.infrastructure.persistent.dao;

import com.zhang.infrastructure.persistent.po.StrategyAward;
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
}
