package com.zhang.domain.activity.service.product;

import com.zhang.domain.activity.model.entity.SkuProductEntity;
import com.zhang.domain.activity.repository.IActivityRepository;
import com.zhang.domain.activity.service.IRaffleActivitySkuProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ZhangJunjie
 * @Description: sku商品服务
 * @DateTime: 2026/6/29 8:41
 **/
@Service
public class RaffleActivitySkuProductService implements IRaffleActivitySkuProductService {
    @Resource
    private IActivityRepository repository;

    @Override
    public List<SkuProductEntity> querySkuProductEntityListByActivityId(Long activityId) {
        return repository.querySkuProductEntityListByActivityId(activityId);
    }

}
