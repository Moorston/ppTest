package com.mo.base.mapper;

import com.mo.base.entity.Logininfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Moonston on 2017/10/24.
 */
public interface LogininfoMapper {

    /**
     * 添加用户
     */
    int insertUser(Logininfo record);

    /**
     * 根据ID查询用户
     */
    Logininfo selectUserById(Long id);

    /**
     * 查询所有的用户
     */
    List<Logininfo> selectAll();

    /**
     * 更改用户信息
     */
    int updateById(Logininfo record);

    /**
     * 根据用户名查询用户数量
     */
    int getCountByUsername(String username);

    /**
     * 登录
     */
    Logininfo login(@Param("username")String username,
                    @Param("password")String password, @Param("userType")int userType);

    /**
     * 按照类型查询用户数量
     */
    int countByUserType(int userType);

}
