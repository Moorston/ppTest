package com.mo.base.entity;

import java.util.Date;

/**
 * Created by Moonston on 2017/10/25.
 * 登录日记
 * 记录登录的状态、时间、ip等
 */
public class Iplog extends BaseEntity{

    //定义登录状态
    public static final int STATE_SUCCESS = 1;
    public static final int STATE_FAILED = 0;

    private String ip;//登录ip
    private Date loginTime;//登录时间
    private String username;//登录名
    private Long logininfoId; //登录id
    private int loginstate;//登录状态
    private int loginType;//用户登录类型

    public String getStateDesplay(){
        return loginstate == STATE_SUCCESS?"登录成功":"登录失败";
    }

    public String getUserTypeDesplay(){
        return loginstate == Logininfo.USER_CLIENT?"前端用户":"后台管理";
    }

    public static int getLoginstateSuccess() {
        return STATE_SUCCESS;
    }

    public static int getLoginstateFailed() {
        return STATE_FAILED;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLoginstate() {
        return loginstate;
    }

    public void setLoginstate(int loginstate) {
        this.loginstate = loginstate;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public Long getLogininfoId() {
        return logininfoId;
    }

    public void setLogininfoId(Long logininfoId) {
        this.logininfoId = logininfoId;
    }
}
