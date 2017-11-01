package com.mo.base.mapper;


import com.mo.base.entity.RealAuth;
import com.mo.base.query.RealAuthQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Moonston on 2017/10/29.
 */
public interface RealAuthMapper {

    /**
     * 插入认证信息
     * @param record
     * @return
     */
    int insert(@Param("ra") RealAuth record);

    /**
     * 根据ID查询认证信息
     * @param id
     * @return
     */
    RealAuth selectByPrimaryKey(Long id);

    /**
     * 分页,查询结果集数
     */
    int queryForCount(@Param("qo")RealAuthQueryObject qo);

    /**
     * 查询所有实名认证的信息
     * @return
     */
    List<RealAuth> query(@Param("qo")RealAuthQueryObject qo);

    /**
     * 更新实名认证信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(RealAuth record);


}
