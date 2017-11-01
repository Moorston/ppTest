package com.mo.base.Interceptor;

import com.mo.base.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Moonston on 2017/10/29.
 */
public class SystemSessionInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SystemSessionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {
        //session中获取用户名信息
         obj = UserContext.getCurrent();
        if (obj==null||"".equals(obj.toString())) {
            response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object obj, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object obj, Exception e) throws Exception {

    }
}
