package com.mo.base.query;

import com.mo.base.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Moonston on 2017/10/29.
 */
public class RealAuthQueryObject extends QueryObject{

    private int state = -1;//全部结果集
    private Date beginDate;//开始时间
    private Date endDate;//结束使劲

    public int getState() {
        return state;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    public void setState(int state) {
        this.state = state;
    }


    public Date getBeginDate() {
        return beginDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate == null ? null : DateUtil.endOfDay(endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
