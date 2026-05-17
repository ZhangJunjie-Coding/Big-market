package com.zhang.domain.activity.service.rule;

/**
 * @Author: ZhangJunjie
 * @Description: 下单规则责任链抽象类
 * @DateTime: 2026/5/17 11:46
 **/
public abstract class AbstractActionChain implements IActionChain{

    private IActionChain next;

    @Override
    public IActionChain next() {
        return next;
    }

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }
}
