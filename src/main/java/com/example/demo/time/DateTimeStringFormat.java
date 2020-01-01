package com.example.demo.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间字符串格式化
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/1/1 20:48
 */
public class DateTimeStringFormat {
    private static final String BASE_DATE_TIME = "2019-12-31 23:59:59";
    /**
     * 注意：直接将SimpleDateFormat声明为static又线程安全风险
     */
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 字符串转换成日期时间
     */
    public static Date string2DateTime() throws ParseException {
        return FORMAT.parse(BASE_DATE_TIME);
    }

    /**
     * 日期时间转换字符串
     */
    public static String dateTime2String() throws ParseException {
        return FORMAT.format(string2DateTime());
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(dateTime2String());
    }
}
