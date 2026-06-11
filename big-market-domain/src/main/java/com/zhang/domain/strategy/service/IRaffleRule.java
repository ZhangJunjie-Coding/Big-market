package com.zhang.domain.strategy.service;

import java.util.Map;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖规则接口
 * @DateTime: 2026/6/11 11:58
 **/
public interface IRaffleRule {
    Map<String,Integer> queryAwardRuleLockCount(String[] treeIds);
}
