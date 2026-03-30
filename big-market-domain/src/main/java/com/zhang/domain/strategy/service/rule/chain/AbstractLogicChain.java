package com.zhang.domain.strategy.service.rule.chain;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/3/29 20:59
 **/
public abstract class AbstractLogicChain implements ILogicChain{

    private ILogicChain next;

    @Override
    public ILogicChain appendNext(ILogicChain chain) {
        this.next = chain;
        return next;
    }

    @Override
    public ILogicChain next() {
        return next;
    }
    protected abstract String ruleModel();
}
