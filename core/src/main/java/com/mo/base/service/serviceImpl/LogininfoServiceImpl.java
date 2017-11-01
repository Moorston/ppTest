package com.mo.base.service.serviceImpl;

import com.mo.base.entity.Account;
import com.mo.base.entity.Iplog;
import com.mo.base.entity.Logininfo;
import com.mo.base.entity.Userinfo;
import com.mo.base.exception.LogicException;
import com.mo.base.mapper.IplogMapper;
import com.mo.base.mapper.LogininfoMapper;
import com.mo.base.service.IAccountService;
import com.mo.base.service.ILogininfoService;
import com.mo.base.service.IUserinfoService;
import com.mo.base.utils.MD5;
import com.mo.base.utils.UserContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Moonston on 2017/10/24.
 */
@Service
public class LogininfoServiceImpl implements ILogininfoService,Serializable {

    private static final Logger logger = Logger.getLogger(LogininfoServiceImpl.class);

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private IplogMapper iplogMapper;

    /**
     * 用户注册
     * @param username
     * @param password
     */
    @Override
    public void register(String username, String password) {
        //判断用户是否存在
        boolean isExist=checkUsername(username);
        if (!isExist){//如果不存在,则注册
            //创建一个Logininfo对象
            Logininfo register = new Logininfo();
            register.setUsername(username);
            System.out.println("register user password:"+password);
            register.setPassword(MD5.encode(password));
            register.setState(Logininfo.STATE_NORMAL);
            register.setUserType(Logininfo.USER_CLIENT);
            this.logininfoMapper.insertUser(register);

            //初始化账户和userinfo用户信息
            Account account = new Account();
            account.setId(register.getId());
            accountService.addAccount(account);

            Userinfo userinfo = new Userinfo();
            userinfo.setId(register.getId());
            userinfoService.addUserinfo(userinfo);

        }else {
            //如果存在
            System.out.println("用户已存在！");
            throw new RuntimeException("用户已存在!!!");
        }
    }

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    @Override
    public boolean checkUsername(String username) {
        return this.logininfoMapper.getCountByUsername(username)>0;
    }

    @Override
    public Logininfo login(String username, String password, int userType,String ip) {
        Logininfo currentUser =this.logininfoMapper.login(username,MD5.encode(password),userType);

        Iplog iplog = new Iplog();
        iplog.setIp(ip);
        iplog.setLoginTime(new Date());
        iplog.setUsername(username);
        iplog.setLoginType(userType);
        if (currentUser!=null){
            //将用户信息放到session中
            //创建session对象
            UserContext.putCurrent(currentUser);
            iplog.setLogininfoId(currentUser.getId());
            iplog.setLoginstate(Iplog.STATE_SUCCESS);
            System.out.println("currentUser:"+currentUser);
        }else {
            iplog.setLogininfoId(-1L);
            iplog.setLoginstate(Iplog.STATE_FAILED);
            System.out.println("currentUser1:"+currentUser);
        }
        iplogMapper.insert(iplog);
        return currentUser;
    }

    @Override
    public void initAdmin() {

    }
}
