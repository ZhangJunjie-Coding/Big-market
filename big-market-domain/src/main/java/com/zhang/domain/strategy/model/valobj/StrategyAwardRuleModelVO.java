package com.zhang.domain.strategy.model.valobj;

import com.zhang.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import com.zhang.types.common.Constants;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖策略规则的规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 * @DateTime: 2026/3/29 10:29
 **/
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {
    private String ruleModels;

    public String[] raffleCenterRuleModelList() {
        List<String> ruleModelList = new ArrayList<>();
        String[] ruleModelValues = ruleModels.split(Constants.SPLIT);
        for (String ruleModelValue : ruleModelValues) {
            if (DefaultLogicFactory.LogicModel.isCenter(ruleModelValue)) {
                ruleModelList.add(ruleModelValue);
            }
        }
        return ruleModelList.toArray(new String[0]);
    }
}
