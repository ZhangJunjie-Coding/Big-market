package com.zhang.trigger.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ZhangJunjie
 * @Description: 抽奖奖品列表,响应对象
 * @DateTime: 2026/4/11 15:49
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RaffleAwardListResponseDTO {

    // 奖品ID
    private Integer awardId;
    // 奖品标题
    private String awardTitle;
    // 奖品副标题 【抽奖一次后解锁】
    private String awardSubtitle;
    // 排序编号
    private Integer sort;


}
