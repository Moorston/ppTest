package com.mo.base.controller;

import com.mo.base.entity.Account;
import com.mo.base.entity.Logininfo;
import com.mo.base.service.IAccountService;
import com.mo.base.service.IUserinfoService;
import com.mo.base.utils.JSONResult;
import com.mo.base.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Moonston on 2017/10/28.
 */
@Controller
public class PersonalController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IUserinfoService userinfoService;

    @RequestMapping("/personal.do")
    public String personCenter(Model model){
        //從session中獲取當前用戶
        Logininfo current = UserContext.getCurrent();
        Account account = accountService.getAccount(current.getId());
        //獲取到賬戶信息並將信息存放在Model中
        model.addAttribute("userinfo",userinfoService.getUserinfo(current.getId()));
        model.addAttribute("account",accountService.getAccount(current.getId()));
        return "personal";
    }

    public JSONResult bindPhone(String phoneNumber,String verifyCode){
        JSONResult json = new JSONResult();

        try {
            this.userinfoService.bindPhone(phoneNumber,verifyCode);

        }catch (RuntimeException e){
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }
}
