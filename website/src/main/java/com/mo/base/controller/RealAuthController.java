package com.mo.base.controller;

import com.mo.base.entity.RealAuth;
import com.mo.base.entity.Userinfo;
import com.mo.base.service.IRealAuthService;
import com.mo.base.service.IUserinfoService;
import com.mo.base.utils.JSONResult;
import com.mo.base.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

/**
 * Created by Moonston on 2017/10/29.
 */
@Controller
public class RealAuthController {

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private IRealAuthService realAuthService;

    @Autowired
    private ServletContext servletContext;

    /**
     * 实名认证情况
     * @param model
     * @return
     */
    @RequestMapping("realAuth.do")
    public String saveRealAuth(Model model){

        //等到当前用户的用户信息,即获取该用户Userinfo
        Userinfo current = userinfoService.getCurrentUserinfo();
        //判断该用户是否已经实名认证
        if (current.getIsRealAuth()){//1.已实名认证
            // 根据userinfo上的realAuthId得到实名认证对象,并放到model;
            RealAuth ra = this.realAuthService.getRealAuth(current.getId());
            System.out.println(ra.getRealName());
            System.out.println(ra.getIdNumber());
            model.addAttribute("realAuth",ra);

            //设置审核状态auditing=false
            model.addAttribute("auditing",false);
            model.addAttribute("userinfo",this.userinfoService.getCurrentUserinfo());
            return "realAuth_result";

        }else {//未实名认证
            //如果用户已提交审核，则将审核状态设置成已提交未审核状态
            if (current.getRealAuthId()!=null){
                model.addAttribute("auditing",true);
                return "realAuth_result";
            }else {//如果未实名认证则跳转到实名认证信息填写界面
                return "realAuth";
            }
        }
    }

    /**
     * 申请实名认证
     * @param realAuth
     * @return
     */
    @RequestMapping("applyRealAuth.do")
    @ResponseBody
    public JSONResult applyRealAuth(RealAuth realAuth){
        JSONResult json = new JSONResult();
        //检查是否已经提交成功
        boolean isApply=this.realAuthService.applyRealAuth(realAuth);
        if (!isApply){
            json.setSuccess(false);
            json.setMsg("申请提交失败！！！");
        }else {
            json.setSuccess(true);
            json.setMsg("申请提交成功！");
        }
        return json;
    }

    @RequestMapping("realAuthUpload.do")
    @ResponseBody
    public String realAuthUpload(MultipartFile file){
        //得到basepath
        String basepath = servletContext.getRealPath("/upload");
        String fileName = UploadUtil.upload(file,basepath);
        return "/upload/"+fileName;
    }
}
