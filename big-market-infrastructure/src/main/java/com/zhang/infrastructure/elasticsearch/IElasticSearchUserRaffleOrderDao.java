package com.zhang.infrastructure.elasticsearch;

import com.zhang.infrastructure.elasticsearch.po.UserRaffleOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: TODO
 * @DateTime: 2026/7/6 11:54
 **/
@Mapper
public interface IElasticSearchUserRaffleOrderDao {
    List<UserRaffleOrder> queryUserRaffleOrderList();
}
