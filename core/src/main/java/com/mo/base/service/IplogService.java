package com.mo.base.service;

import com.mo.base.query.IplogQueryObject;
import com.mo.base.query.QueryPageResult;

/**
 * Created by Moonston on 2017/10/28.
 */
public interface IplogService {

    /**
     * 分页查询
     *
     * @param qo
     * @return
     */
    QueryPageResult query(IplogQueryObject qo);
}
