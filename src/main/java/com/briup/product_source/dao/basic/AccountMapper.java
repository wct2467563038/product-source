package com.briup.product_source.dao.basic;

import com.briup.product_source.bean.basic.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(String accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}