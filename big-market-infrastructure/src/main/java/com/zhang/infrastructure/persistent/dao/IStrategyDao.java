package com.zhang.infrastructure.persistent.dao;

import com.zhang.infrastructure.persistent.po.Strategy;
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
}
