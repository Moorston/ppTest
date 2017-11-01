package com.mo.base.controller;

import com.mo.base.entity.Logininfo;
import com.mo.base.service.ILogininfoService;
import com.mo.base.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Moonston on 2017/10/24.
 */
@Controller
public class LoginController {

    @Autowired
    private ILogininfoService logininfoService;

    @RequestMapping("loginmgr.do")
    @ResponseBody
    public JSONResult login(String username, String password, HttpServletRequest request){
        JSONResult json = new JSONResult();
        String ip = request.getRemoteAddr();
        Logininfo currentUser = this.logininfoService.login(username,password,Logininfo.USER_CLIENT,ip);
        if (currentUser==null){
            json.setSuccess(false);
            json.setMsg("用户名或密码错误");
        }
        json.setSuccess(true);
        json.setMsg("登陆成功");
        System.out.println(json.getMsg());
        return json;
    }


}
