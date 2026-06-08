package com.zhang.infrastructure.persistent.dao;

import com.zhang.infrastructure.persistent.po.RaffleActivitySku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: 商品sku DAO
 * @DateTime: 2026/5/16 21:57
 **/
@Mapper
public interface IRaffleActivitySkuDao {


    RaffleActivitySku queryActivitySku(Long sku);

    void updateActivitySkuStock(Long sku);

    void clearActivitySkuStock(Long sku);

    List<RaffleActivitySku> queryActivitySkuListByActivityId(Long activityId);
}
