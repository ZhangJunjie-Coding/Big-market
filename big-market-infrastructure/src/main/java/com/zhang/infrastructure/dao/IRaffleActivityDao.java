package com.zhang.infrastructure.dao;

import com.zhang.infrastructure.dao.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖活动表Dao
 * @DateTime: 2026/5/16 14:21
 **/
@Mapper
public interface IRaffleActivityDao {
    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

    Long queryStrategyIdByActivityId(Long activityId);

    Long queryActivityIdByStrategyId(Long strategyId);

}
