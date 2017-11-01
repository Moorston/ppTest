package com.mo.base.controller;

import com.mo.base.service.IVerifyCodeService;
import com.mo.base.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Moonston on 2017/11/1.
 */
@Controller
public class VerifyCodeController {

    @Autowired
    private IVerifyCodeService verifyCodeService;

    public JSONResult sendVerifyCode(String phoneNumber){
        JSONResult json = new JSONResult();

        try {
            verifyCodeService.sendVeriyCode(phoneNumber);

        }catch (RuntimeException e){
            json.setSuccess(false);
            json.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return json;
    }
}
