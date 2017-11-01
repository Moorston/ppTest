package com.mo.base.service;

/**
 * Created by Moonston on 2017/11/1.
 */
public interface IVerifyCodeService {

    /**
     * 给指定的手机发送验证码
     * @param phoneNumber
     */
    void sendVeriyCode(String phoneNumber);


    /**
     * 验证手机验证码
     * @param phoneNumber
     * @param verifyCode
     * @return
     */
    boolean verify(String phoneNumber,String verifyCode);
}
