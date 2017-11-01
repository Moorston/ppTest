package com.mo.base.service;

import com.mo.base.entity.Logininfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Moonston on 2017/10/24.
 *
 * 登录相关服务
 **/

public interface ILogininfoService {

    /**
     * 用户注册
     * @param username
     * @param password
     */
    void register(String username,String password);

    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /**
     * 用户登录
     * @param username
     * @param password
     * @param userType
     * @return
     */
    Logininfo login(String username,String password,int userType,String ip);

    /**
     * 初始化第一个管理员
     */
    void initAdmin();

}
