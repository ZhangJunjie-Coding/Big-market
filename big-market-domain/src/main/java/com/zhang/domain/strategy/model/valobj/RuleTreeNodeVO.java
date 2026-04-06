package com.zhang.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 规则树节点对象
 * @DateTime: 2026/3/30 14:26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleTreeNodeVO {
    // 规则树ID
    private String treeId;
    // 规则key
    private String ruleKey;
    // 规则描述
    private String ruleDesc;
    // 规则比值
    private String ruleValue;

    // 规则连线
    private List<RuleTreeNodeLineVO> treeNodeLineVOList;

}
