package com.zhang.domain.rebate.repository;

import com.zhang.domain.rebate.model.aggregate.BehaviorRebateAggregate;
import com.zhang.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import com.zhang.domain.rebate.model.valobj.BehaviorTypeVO;
import com.zhang.domain.rebate.model.valobj.DailyBehaviorRebateVO;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 行为返利服务仓储接口
 * @DateTime: 2026/6/16 22:21
 **/
public interface IBehaviorRebateRepository {

    List<DailyBehaviorRebateVO> queryDailyBehaviorRebateConfig(BehaviorTypeVO behaviorTypeVO);

    void saveUserRebateRecord(String userId, List<BehaviorRebateAggregate> behaviorRebateAggregates);

    List<BehaviorRebateOrderEntity> queryOrderByOutBusinessNo(String userId, String outBusinessNo);
}
