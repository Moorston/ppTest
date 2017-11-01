package com.mo.base.mapper;

import com.mo.base.entity.Account;
import java.util.List;

public interface AccountMapper {

    int insert(Account record);

    int updateByPrimaryKey(Account record);

    Account selectByPrimaryKey(Long id);

    List<Account> selectAll();
}