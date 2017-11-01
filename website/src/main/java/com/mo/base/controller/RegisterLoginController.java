package com.mo.base.controller;

import com.mo.base.entity.Logininfo;
import com.mo.base.exception.LogicException;
import com.mo.base.service.ILogininfoService;
import com.mo.base.utils.JSONResult;
import com.mo.base.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用于注册/登陆相关
 * Created by Moonston on 2017/10/24.
 */
@Controller
public class RegisterLoginController {

    @Autowired
    private ILogininfoService logininfoService;

    @RequestMapping("register.do")
    @ResponseBody
    public JSONResult register(String username,String password){
        System.out.println("username："+username+"password:"+password);
        JSONResult json = new JSONResult();
        try{
            logininfoService.register(username,password);
        }catch (RuntimeException e){
            System.out.println("注册失败！");
            json.setSuccess(false);
            json.setMsg(e.getMessage());
        }
        return json;
    }

    @RequestMapping("checkUsername.do")
    @ResponseBody
    public Boolean checkUsername(String username){

        return !logininfoService.checkUsername(username);
    }

    @RequestMapping("login.do")
    @ResponseBody
    public JSONResult login(String username,String password,HttpServletRequest request){

        String ip = request.getRemoteAddr();
        JSONResult jsonResult = new JSONResult();
        Logininfo current = this.logininfoService.login(username,password,Logininfo.USER_CLIENT,ip);
        if (current==null){
            jsonResult.setSuccess(false);
            jsonResult.setMsg("用户名或密码错误！!!!");
        }
        return jsonResult;
    }

    @RequestMapping("logout.do")
    public void logout(HttpServletRequest request, HttpServletResponse response)
            throws Exception{
       Logininfo user = UserContext.getCurrent();
       HttpSession session = request.getSession();
       session.removeAttribute(UserContext.USER_IN_SESSION);
       response.sendRedirect("/login.html");
    }
}
