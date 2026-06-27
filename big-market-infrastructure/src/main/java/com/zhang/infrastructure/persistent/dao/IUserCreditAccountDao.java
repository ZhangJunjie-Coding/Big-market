package com.zhang.infrastructure.persistent.dao;

import com.zhang.infrastructure.persistent.po.UserCreditAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ZhangJunjie
 * @Description: 用户积分账户
 * @DateTime: 2026/6/22 16:20
 **/
@Mapper
public interface IUserCreditAccountDao {
    void insert(UserCreditAccount userCreditAccountReq);

    int updateAddAmount(UserCreditAccount userCreditAccountReq);

    UserCreditAccount queryUserCreditAccount(UserCreditAccount userCreditAccountReq);
}
