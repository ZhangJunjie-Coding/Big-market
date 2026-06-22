package com.zhang.domain.award.repository;

import com.zhang.domain.award.model.aggregate.GiveOutPrizesAggregate;
import com.zhang.domain.award.model.aggregate.UserAwardRecordAggregate;

/**
 * @Author: ZhangJunjie
 * @Description: T奖品仓储服务
 * @DateTime: 2026/5/19 22:03
 **/
public interface IAwardRepository {
    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);

    String queryAwardConfig(Integer awardId);

    void saveGiveOutPrizesAggregate(GiveOutPrizesAggregate giveOutPrizesAggregate);

    String queryAwardKey(Integer awardId);
}
