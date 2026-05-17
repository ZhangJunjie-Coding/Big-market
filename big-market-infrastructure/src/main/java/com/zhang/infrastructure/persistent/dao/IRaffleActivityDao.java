package com.zhang.infrastructure.persistent.dao;

import com.zhang.domain.activity.model.aggregate.CreateOrderAggregate;
import com.zhang.infrastructure.persistent.po.RaffleActivity;
import com.zhang.infrastructure.persistent.po.RaffleActivityOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖活动表Dao
 * @DateTime: 2026/5/16 14:21
 **/
@Mapper
public interface IRaffleActivityDao {
    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

}
