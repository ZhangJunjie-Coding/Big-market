package com.zhang.domain.strategy.service.rule.chain;

/**
 * @Author: ZhangJunjie
 * @Description: 装配
 * @DateTime: 2026/3/29 21:56
 **/
public interface ILogicChainArmory {

    ILogicChain appendNext(ILogicChain chain);

    ILogicChain next();

}
