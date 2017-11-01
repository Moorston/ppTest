package com.mo.base.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Moonston on 2017/10/28.
 */
public class DateUtil {

    /**
     * 得到一天的最后一秒
     */
    public static Date endOfDay(Date date){
        return DateUtils.addSeconds(DateUtils.addDays(DateUtils.truncate(date, Calendar.DATE),1),-1);
    }

    /**
     * 两个时间的间隔秒
     *
     * @return
     */
    public static long secondsBetween(Date d1, Date d2) {
        return Math.abs((d1.getTime() - d2.getTime()) / 1000);
    }
}
