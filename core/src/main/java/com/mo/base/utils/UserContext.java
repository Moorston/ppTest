package com.mo.base.utils;

import com.mo.base.entity.Logininfo;
import com.mo.base.vo.VerifyCodeVO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Moonston on 2017/10/25.
 * 用于存放当前用户的上下文
 */
public class UserContext {

    //登录的session
    public static final String USER_IN_SESSION = "logininfo";
    public static final String VERIFYCODE_IN_SESSION = "verifycode_in_session";

    /**
     * 反向获取request的方法,请查看RequestContextListener.requestInitialized打包过程
     *
     * @return
     */
    private static HttpSession getSession(){
        HttpSession session= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        System.out.println("Session:"+session.getAttributeNames());
        return session;
    }

    public static void putCurrent(Logininfo current){
        System.out.println("UserCurrent:"+current.getUsername());
        // 得到session,并把current放到session中
        getSession().setAttribute(USER_IN_SESSION,current);
    }

    public static Logininfo getCurrent(){
        return (Logininfo) getSession().getAttribute(USER_IN_SESSION);
    }

    public static void putVerifyCode(VerifyCodeVO vc){
        System.out.println("VerifyCodeCurrent:"+vc.getVerifyCode());
        getSession().setAttribute(VERIFYCODE_IN_SESSION,vc);
    }

    /**
     * 得到当前的短信验证码
     *
     * @return
     */
    public static VerifyCodeVO getCurrentVerifyCode(){
        return (VerifyCodeVO) getSession().getAttribute(VERIFYCODE_IN_SESSION);
    }

}
