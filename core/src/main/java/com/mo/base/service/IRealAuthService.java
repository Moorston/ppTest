package com.mo.base.service;

import com.mo.base.entity.RealAuth;
import com.mo.base.query.QueryPageResult;
import com.mo.base.query.RealAuthQueryObject;

/**
 * Created by Moonston on 2017/10/29.
 */
public interface IRealAuthService {

    /**
     * 根据ID获取实名认证信息
     * @param id
     * @return
     */
    RealAuth getRealAuth(Long id);

    /**
     * 实名认证申请
     * @param realAuth
     */
    boolean applyRealAuth(RealAuth realAuth);

    /**
     * 实名认证列表
     * @param qo
     * @return
     */
    QueryPageResult query(RealAuthQueryObject qo);

    /**
     * 实名认证审核
     * @param id
     * @param remark
     * @param state
     */
    void audit(Long id, String remark, int state);


}
