package com.mo.base.controller;

import com.mo.base.query.IplogQueryObject;
import com.mo.base.service.IplogService;
import com.mo.base.utils.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Moonston on 2017/10/28.
 */
@Controller
public class IplogController {

    private static final Logger logger = LoggerFactory.getLogger(IplogController.class);

    @Autowired
    private IplogService iplogService;

    /**
     * 个人用户登陆记录列表
     * @param qo
     * @param model
     * @return
     */
    @RequestMapping("/ipLog.do")
    public String showIplog(@ModelAttribute("qo") IplogQueryObject qo, Model model){
        qo.setUsername(UserContext.getCurrent().getUsername());
        System.out.println("endate："+qo.getEndDate());
        model.addAttribute("pageResult",this.iplogService.query(qo));
        return "iplog_list";
    }

}
