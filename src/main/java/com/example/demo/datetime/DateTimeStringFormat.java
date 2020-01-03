package com.example.demo.datetime;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
        String[] formArray = {"yyyy-MM-dd", BASE_PATTERN_STRING};
        //DateUtils.parseDate()方法的parsePatterns参数可以传入多个值，其中至少有一个可以成功解析该字符串即可，否则报错。
        DateUtils.parseDate(BASE_DATE_TIME, formArray);

        //该方法和 DateUtils.parseDate() 方法作用相同，只不过它对于字符串的要求更严格。
        DateUtils.parseDateStrictly(BASE_DATE_TIME, formArray);

        return DateUtils.parseDate(BASE_DATE_TIME, BASE_PATTERN_STRING);
    }

    /**
     * 字符串转换成日期时间（使用Java 8的LocalDateTime）
     */
    public static LocalDateTime string2DateTimeByJava8() {
        return LocalDateTime.parse(BASE_DATE_TIME, DATE_TIME_FORMATTER);
    }

    /**
     * 日期时间转换字符串
     */
    public static String dateTime2String() throws ParseException {
        return FORMAT.format(string2DateTime());
    }

    /**
     * 日期时间转换成字符串（使用DateUtils）
     * 该方法中包含DateFormatUtils.format()三个重载方法，且以下三个方法返回的结果相同
     */
    public static String dateTime2StringByDateUtils() throws ParseException {
        //String DateFormatUtils.format(long millis, String pattern)
        DateFormatUtils.format(string2DateTime().getTime(), BASE_PATTERN_STRING);

        //String DateFormatUtils.format(Calendar calendar, String pattern)
        Calendar cal = Calendar.getInstance();
        cal.setTime(string2DateTime());
        DateFormatUtils.format(cal, BASE_PATTERN_STRING);

        //String DateFormatUtils.format(Date date, String pattern)
        return DateFormatUtils.format(string2DateTime(), BASE_PATTERN_STRING);
    }

    /**
     * 日期时间转换成字符串（使用Java 8的LocalDateTime）
     */
    public static String dateTime2StringByJava8() {
        return string2DateTimeByJava8().format(DATE_TIME_FORMATTER);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(string2DateTimeByDateUtils());
    }
}
