package com.mo.base.mapper;

import com.mo.base.entity.Userinfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Moonston on 2017/10/25.
 */
public interface UserinfoMapper {

    /**
     * 添加用户信息
     * @param record
     * @return
     */
    int insertUserInfo(Userinfo record);

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    Userinfo selectUserInfoById(Long id);

    /**
     * 根据ID修改用户信息
     * @param userinfo
     * @return
     */
    int updateUserInfo(Userinfo userinfo);

    /**
     * 根据关键字查询用户
     */
    List<Map<String,Object>> autoComplateByKey(String keyWord);
}
