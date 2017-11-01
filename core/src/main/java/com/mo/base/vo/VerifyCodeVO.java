package com.mo.base.vo;

import java.util.Date;

/**
 * Created by Moonston on 2017/10/31.
 * 存放验证码相关内容,这个对象是放在session中的
 */
public class VerifyCodeVO {
    private String verifyCode;//验证码
    private String phoneName ;//发送验证码的手机号码
    private Date lastSendTime;//最近成功发送时间

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public Date getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(Date lastSendTime) {
        this.lastSendTime = lastSendTime;
    }
}
