package com.zhang.domain.activity.service.quota.rule;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖动作责任链装配
 * @DateTime: 2026/5/17 11:44
 **/
public interface IActionChainArmory {

    IActionChain next();

    IActionChain appendNext(IActionChain next);

}
