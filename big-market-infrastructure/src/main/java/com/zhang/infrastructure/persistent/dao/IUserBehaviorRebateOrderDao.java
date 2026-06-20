package com.zhang.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import com.zhang.infrastructure.persistent.po.UserBehaviorRebateOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 用户行为返利流水订单表
 * @DateTime: 2026/6/16 21:56
 **/

@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserBehaviorRebateOrderDao {

    void insert(UserBehaviorRebateOrder userBehaviorRebateOrder);

    @DBRouter
    List<UserBehaviorRebateOrder> queryOrderByOutBusinessNo(UserBehaviorRebateOrder userBehaviorRebateOrderReq);
}
