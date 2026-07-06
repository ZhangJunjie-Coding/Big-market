package com.zhang.infrastructure.dao;

import com.zhang.infrastructure.dao.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZhangJunjie
 * @description 规则树节点连线表DAO
 */
@Mapper
public interface IRuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineListByTreeId(String treeId);

}
