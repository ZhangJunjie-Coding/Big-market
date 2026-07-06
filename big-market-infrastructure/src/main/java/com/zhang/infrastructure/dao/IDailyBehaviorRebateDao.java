package com.zhang.infrastructure.dao;

import com.zhang.infrastructure.dao.po.DailyBehaviorRebate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/6/16 21:56
 **/
@Mapper
public interface IDailyBehaviorRebateDao {

    List<DailyBehaviorRebate> queryDailyBehaviorRebateByBehaviorType(String behaviorType);

}
