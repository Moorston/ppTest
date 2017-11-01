package com.mo.base.service;

import com.mo.base.entity.Account;

/**
 * 用户账号相关服务
 * Created by Moonston on 2017/10/26.
 */
public interface IAccountService {

    void update(Account account);

    void addAccount(Account account);

    Account getAccount(Long id);

    /**
     * 得到当前登陆用户对应的账户信息
     *
     * @return
     */
    Account getCurrent();

    /**
     * 定时检查账户篡改
     */
    void checkAccounts();
}
