package com.zhang.domain.activity.service.rule;

import com.zhang.domain.activity.model.entity.ActivityCountEntity;
import com.zhang.domain.activity.model.entity.ActivityEntity;
import com.zhang.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖动作责任链装配
 * @DateTime: 2026/5/17 11:44
 **/
public interface IActionChainArmory {

    IActionChain next();

    IActionChain appendNext(IActionChain next);

}
