package com.zhang.infrastructure.dao;

import com.zhang.infrastructure.dao.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZhangJunjie
 * @description 规则树表DAO
 */
@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);

}
