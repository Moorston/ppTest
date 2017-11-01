package com.mo.base.service.serviceImpl;

import com.mo.base.entity.Account;
import com.mo.base.mapper.AccountMapper;
import com.mo.base.service.IAccountService;
import com.mo.base.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Moonston on 2017/10/26.
 */
@Service
public class AccountServiceImpl implements IAccountService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void update(Account account) {
        int ret = this.accountMapper.updateByPrimaryKey(account);
        if (ret==0){
            throw new RuntimeException("乐观锁失败—>Account："+account.getId());
        }
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("ss:"+account);
        this.accountMapper.insert(account);
    }

    @Override
    public Account getAccount(Long id) {
        Account account = this.accountMapper.selectByPrimaryKey(id);
//        if (!account.checkVerifyCode()){//校验数据
//            throw new RuntimeException("账户："+id+"资金数据异常,阻止业务继续进行");
//        }
        return account;
    }

    @Override
    public Account getCurrent() {
        return this.getAccount(UserContext.getCurrent().getId());
    }

    @Override
    public void checkAccounts() {
        List<Account> list = this.accountMapper.selectAll();
        for (Account account:list){
            if (!account.checkVerifyCode()){//校验数据
                System.out.println("账户："+account.getId()+"资金异常");
            }
        }
    }
}
