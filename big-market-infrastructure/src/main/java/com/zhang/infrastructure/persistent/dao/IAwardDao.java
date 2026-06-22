package com.zhang.infrastructure.persistent.dao;

import com.zhang.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 奖品信息 DAO
 * @DateTime: 2026/3/19 15:04
 **/
@Mapper
public interface IAwardDao {
    List<Award> queryAwardList();

    String queryAwardConfigByAwardId(Integer awardId);

    String queryAwardKeyByAwardId(Integer awardId);
}
