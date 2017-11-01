package com.mo.base.service;

import com.mo.base.entity.Userinfo;

import java.util.List;
import java.util.Map;

/**
 * 用户相关信息服务
 * Created by Moonston on 2017/10/25.
 */
public interface IUserinfoService {

    /**
     * 乐观锁支持
     * @param userinfo
     */
    void update(Userinfo userinfo);

    /**
     * 添加userinfo
     * @param userinfo
     */
    void addUserinfo(Userinfo userinfo);

    /**
     * 通过id获取userinfo信息
     * @param id
     * @return
     */
    Userinfo getUserinfo(Long id);

    /**
     * 获取当前用户的userinfo
     *
     */
    Userinfo  getCurrentUserinfo();

    /**
     * 用于用户的autcomplate
     * 返回的MAP:{id:logininfoId,username:username}
     * @param keyword
     * @return
     */
    List<Map<String, Object>> autoComplate(String keyword);

    /**
     * 绑定手机
     * @param phoneNumber
     * @param verifyCode
     */
    void bindPhone(String phoneNumber,String verifyCode);

}
