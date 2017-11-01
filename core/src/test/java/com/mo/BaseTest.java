package com.mo;

import com.mo.base.entity.RealAuth;
import com.mo.base.query.RealAuthQueryObject;
import com.mo.base.service.ILogininfoService;
import com.mo.base.service.IRealAuthService;
import com.mo.base.service.serviceImpl.LogininfoServiceImpl;
import com.mo.base.service.serviceImpl.RealAuthServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Moonston on 2017/10/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        ("classpath:applicationContext.xml") //加载配置文件
public class BaseTest {

    @Autowired
    private IRealAuthService realAuthService = new RealAuthServiceImpl();

    @Autowired
    private ILogininfoService logininfoService = new LogininfoServiceImpl();

//    @Test
//    public void testApply(){
//        System.out.println("Hello");
//        realAuthService.applyRealAuth(new RealAuth());
//    }

//    @Test
//    public void testSelect(){
//        realAuthService.query(new RealAuthQueryObject());
//    }

//    @Test
//    public void login(){
//        logininfoService.login("andicle","momo",1,"127.0.0.1");
//    }
}
