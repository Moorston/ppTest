package com.mo.base.utils;

import java.math.BigDecimal;

/**
 * 系统中的常量
 * Created by Moonston on 2017/10/26.
 */
public class BidConst {

    /**
     * 定义存储精度
     */
    public static final int STORE_SCALE = 4;

    /**
     * 定义运算精度
     */
    public static final int CAL_SCALE = 8;
    /**
     * 定义显示精度
     */
    public static final int DISPLAY_SCALE = 2;

    /**
     * 定义系统级别的0
     */
    public static final BigDecimal ZERO = new BigDecimal("0.0000");

    /**
     * 定义初始授信额度
     */
    public static final BigDecimal INIT_BORROW_LIMIT = new BigDecimal(
            "5000.0000");

    /**
     * 默认管理员的用户名和密码
     */
    public static final String DEFAULT_ADMIN_NAME = "admin";
    public static final String DEFAULT_ADMIN_PASSWORD = "1111";


    /**
     * 存储图片的公共文件夹地址
     */
    public static final String PUBLIC_IMG_SHARE_PATH="E:/DevelopmentalItem/JavaProject/upload/";

    //手机验证码有效时间
    public static final int VERIFYCODE_VAILDATE_SECOND = 300;//单位s

}
