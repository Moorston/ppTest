package com.mo.base.query;

import com.mo.base.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Moonston on 2017/10/28.
 */
public class IplogQueryObject extends QueryObject {
    private Date beginDate;
    private Date endDate;
    private int loginstate = -1;
    private String username;
    private int loginType = -1;


    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 因为IpLogQueryObject里面的参数都是直接让SpringMVC注入进来的 如果没有配置日期的格式,SpringMVC没法注入日期;
     * 所以,最简单的办法,通过添加@DateTimeFormat标签来告诉SpringMVC日期的注入格式
     *
     * @param beginDate
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getUserName(){
        return StringUtils.isEmpty(username) == false ? username : null;
    }

    public Date getEndDate() {
        return endDate == null?null: DateUtil.endOfDay(endDate);
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getLoginstate() {
        return loginstate;
    }

    public void setLoginstate(int loginstate) {
        this.loginstate = loginstate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }
}
