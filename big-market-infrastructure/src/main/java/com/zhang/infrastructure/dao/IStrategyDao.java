package com.zhang.infrastructure.dao;

import com.zhang.infrastructure.dao.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖策略 DAO
 * @DateTime: 2026/3/19 15:04
 **/
@Mapper
public interface IStrategyDao {
    List<Strategy> queryStrategyList();

    Strategy queryStrategyEntityByStrategyId(Long strategyId);
}
