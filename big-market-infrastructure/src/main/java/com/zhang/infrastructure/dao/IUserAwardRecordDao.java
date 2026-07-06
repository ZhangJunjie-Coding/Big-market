package com.zhang.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import com.zhang.infrastructure.dao.po.UserAwardRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ZhangJunjie
 * @Description: 用户中奖记录表
 * @DateTime: 2026/5/18 9:49
 **/
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserAwardRecordDao {
    void insert(UserAwardRecord userAwardRecord);

    int updateAwardRecordCompletedState(UserAwardRecord userAwardRecordReq);
}
