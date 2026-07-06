package com.zhang.infrastructure.dao;

import com.zhang.infrastructure.dao.po.RaffleActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖活动次数配置表
 * @DateTime: 2026/5/16 14:21
 **/
@Mapper
public interface IRaffleActivityCountDao {
    RaffleActivityCount queryRaffleActivityCountByActivityCountId(Long activityCountId);
}
