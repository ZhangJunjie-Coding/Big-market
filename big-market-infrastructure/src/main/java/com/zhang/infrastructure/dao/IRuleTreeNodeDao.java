package com.zhang.infrastructure.dao;

import com.zhang.infrastructure.dao.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZhangJunjie
 * @description 规则树节点表DAO
 */
@Mapper
public interface IRuleTreeNodeDao {

    List<RuleTreeNode> queryRuleTreeNodeListByTreeId(String treeId);

    List<RuleTreeNode> queryRuleLocks(String[] treeIds);
}
