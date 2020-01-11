package com.shrimp.util.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 时间工具类
 * @author: shrimp
 * @date: Created in 2020-01-11 16:02
 * @version: 1.0
 */
public class DateFormatHelper {

    private DateFormatHelper() {
    }

    private final static String FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    /**
     * @Description: long 转字符串
     * @Author Shrimp
     * @date: 2020-01-11 16:41
     * @Param: [time]
     * @Return: java.lang.String
     **/
    public static String long2str(long time) {
        Date d = new Date(time);
        DateFormat df = new SimpleDateFormat(FORMAT_STR);
        return df.format(d);
    }

}
