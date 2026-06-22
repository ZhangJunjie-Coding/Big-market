package com.zhang.domain.award.service.distribute;

import com.zhang.domain.award.model.entity.DistributeAwardEntity;

/**
 * @Author: ZhangJunjie
 * @Description: 分发奖品接口
 * @DateTime: 2026/6/22 16:27
 **/
public interface IDistributeAward {
    void giveOutPrizes(DistributeAwardEntity distributeAwardEntity);
}
