package com.mo.base.service.serviceImpl;

import com.mo.base.entity.Userinfo;
import com.mo.base.mapper.UserinfoMapper;
import com.mo.base.service.IUserinfoService;
import com.mo.base.service.IVerifyCodeService;
import com.mo.base.utils.BitStateUtils;
import com.mo.base.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Moonston on 2017/10/25.
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private IVerifyCodeService verifyCodeService;

    @Override
    public void update(Userinfo userinfo) {
        int ret = this.userinfoMapper.updateUserInfo(userinfo);
        if (ret == 0) {
            throw new RuntimeException("乐观锁失败,Userinfo:" + userinfo.getId());
        }

    }

    @Override
    public void addUserinfo(Userinfo userinfo) {
        this.userinfoMapper.insertUserInfo(userinfo);
    }

    /**
     * 根据id获取Userinfo
     * @param id
     * @return
     */
    @Override
    public Userinfo getUserinfo(Long id) {
        return this.userinfoMapper.selectUserInfoById(id);
    }

    /**
     * 获得当前用户的账户信息
     *
     */
    public Userinfo getCurrentUserinfo(){
        return this.getUserinfo(UserContext.getCurrent().getId());
    }

    public List<Map<String, Object>> autoComplate(String keyword){
        return userinfoMapper.autoComplateByKey(keyword);
    }

    /**
     * 绑定手机
     * @param phoneNumber
     * @param verifyCode
     */
    public void bindPhone(String phoneNumber,String verifyCode){
        //获取当前用户
        Userinfo currentUser = this.getUserinfo(UserContext.getCurrent().getId());

        //判断当前用户是否已绑定手机号
        if (!currentUser.getIsBindPhone()){//如果用户没有绑定手机号
            //验证验证码合法性
            boolean ret = this.verifyCodeService.verify(phoneNumber,verifyCode);
            if (ret){
                // 如果合法,给用户绑定手机
                currentUser.addState(BitStateUtils.OP_BIND_PHONE);
                currentUser.setPhoneNumber(phoneNumber);
                this.update(currentUser);
            }else {
                //抛出异常
                throw new RuntimeException("绑定手机失败");
            }
        }



    }
}
