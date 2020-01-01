package com.example.demo.datetime;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间字符串格式化
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/1/1 20:48
 */
public class DateTimeStringFormat {
    private static final String BASE_DATE_TIME = "2019-12-31 23:59:59";
    private static final String BASE_PATTERN_STRING = "yyyy-MM-dd HH:mm:ss";
    /**
     * 注意：直接将SimpleDateFormat声明为static又线程安全风险
     */
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    /**
     * java 8日期格式化工具
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    /**
     * 字符串转换成日期时间
     */
    public static Date string2DateTime() throws ParseException {
        return FORMAT.parse(BASE_DATE_TIME);
    }

    /**
     * 字符串转换成日期时间（使用DateUtils）
     */
    public static Date string2DateTimeByDateUtils() throws ParseException {
        return DateUtils.parseDate(BASE_DATE_TIME, BASE_PATTERN_STRING);
    }

    /**
     * 字符串转换成日期时间（使用Java 8的API）
     */
    public static Date string2DateTimeByJava8() throws ParseException {
        return DateUtils.parseDate(BASE_DATE_TIME, BASE_PATTERN_STRING);
    }

    /**
     * 日期时间转换字符串
     */
    public static String dateTime2String() throws ParseException {
        return FORMAT.format(string2DateTime());
    }

    /**
     * 日期时间转换成字符串（使用DateUtils）
     *
     * @return 字符串
     */
    public static String dateTime2StringByDateUtils() throws ParseException {
        return DateFormatUtils.format(string2DateTime(), BASE_PATTERN_STRING);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(string2DateTimeByDateUtils());
    }
}
