package com.zhang.domain.strategy.model.entity;

import com.zhang.domain.strategy.model.vo.RuleLogicCheckTypeVO;
import lombok.*;

/**
 * @Author: ZhangJunjie
 * @Description: 规则动作实体
 * @DateTime: 2026/3/22 11:39
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleActionEntity<T extends RuleActionEntity.RaffleEntity> {

    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();

    private String ruleModel;
    private T data;

    static public class RaffleEntity {


    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static public class RaffleBeforeEntity extends RaffleEntity {
        /**
         * 策略ID
         */
        private Long strategyId;

        /**
         * 权重值key: 用于抽奖时可以选择权重抽奖
         */
        private String ruleWeightValueKey;

        /**
         * 奖品ID
         */
        private Integer awardId;
    }

    // 抽奖中的过滤规则
    static public class RaffleCenterEntity extends RaffleEntity {

    }


    static public class RaffleAfterEntity extends RaffleEntity {

    }
}
