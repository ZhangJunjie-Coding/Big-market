package com.zhang.domain.activity.service;

import com.zhang.domain.activity.model.valobj.ActivitySkuStockKeyVO;

/**
 * @Author: ZhangJunjie
 * @Description: 活动sku库存处理接口
 * @DateTime: 2026/5/17 22:43
 **/
public interface IRaffleActivitySkuStockService {

    /**
     * 获取活动sku库存消耗队列
     *
     * @return 奖品库存Key信息
     * @throws InterruptedException 异常
     */
    ActivitySkuStockKeyVO takeQueueValue() throws InterruptedException;

    /**
     * 清空队列
     */
    void clearQueueValue();

    /**
     * 延迟队列 + 任务趋势更新活动sku库存
     *
     * @param sku 活动商品
     */
    void updateActivitySkuStock(Long sku);

    /**
     * 缓存库存以消耗完毕，清空数据库库存
     *
     * @param sku 活动商品
     */
    void clearActivitySkuStock(Long sku);


    /**
     * 标记 sku 库存已归零
     */
    void markActivitySkuStockZero(Long sku);

    /**
     * 判断 sku 库存是否已归零
     */
    boolean isActivitySkuStockZero(Long sku);
}
