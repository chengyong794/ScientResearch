package com.chengyong.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取当前年份的前面若干年
 */
public class YEAR_THERE {
    public static String year(int t){
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, t);
        Date y = c.getTime();
        return format.format(y);
    }
}
