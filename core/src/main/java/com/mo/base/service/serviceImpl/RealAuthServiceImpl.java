package com.mo.base.service.serviceImpl;

import com.mo.base.entity.Logininfo;
import com.mo.base.entity.RealAuth;
import com.mo.base.entity.Userinfo;
import com.mo.base.mapper.LogininfoMapper;
import com.mo.base.mapper.RealAuthMapper;
import com.mo.base.query.QueryPageResult;
import com.mo.base.query.RealAuthQueryObject;
import com.mo.base.service.IRealAuthService;
import com.mo.base.service.IUserinfoService;
import com.mo.base.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Moonston on 2017/10/29.
 */
@Service
public class RealAuthServiceImpl implements IRealAuthService{

    @Autowired
    private RealAuthMapper realAuthMapper;

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private LogininfoMapper logininfoMapper;


    @Override
    public RealAuth getRealAuth(Long id) {
            return realAuthMapper.selectByPrimaryKey(id);
    }


    /**
     * 申请实名认证
     * @param realAuth
     */
    public boolean applyRealAuth(RealAuth realAuth) {

        //获取当前用户信息
        Userinfo current = this.userinfoService.getCurrentUserinfo();
        // 判断当前用户没有实名认证并且当前用户不处于待审核状态
        if (!current.getIsRealAuth() && current.getRealAuthId()==null){
            //保存一个实名认证对象
            realAuth.setState(RealAuth.STATE_NOMAL);
            realAuth.setApplyTime(new Date());
            realAuth.setApplier(UserContext.getCurrent());
            int count=this.realAuthMapper.insert(realAuth);
            // 把实名认证的id设置给userinfo
            current.setRealAuthId(realAuth.getId());
            this.userinfoService.update(current);
            if (count>0){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public QueryPageResult query(RealAuthQueryObject qo) {
        //获取结果集数
        int count = this.realAuthMapper.queryForCount(qo);
        //判断结果集数
        if (count>0){
            //查询显示所有结果集
            List<RealAuth> realAuthList = this.realAuthMapper.query(qo);
            return new QueryPageResult(realAuthList,count,
                    qo.getCurrentPage(),qo.getPageSize());
        }
        return QueryPageResult.empty(qo.getPageSize());
    }

    /**
     * 审核认证
     * @param id
     * @param remark
     * @param state
     */
    @Override
    public void audit(Long id, String remark, int state) {

    }
}
