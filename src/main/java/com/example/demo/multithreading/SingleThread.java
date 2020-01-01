package com.example.demo.multithreading;

import java.util.stream.LongStream;

/**
 * 单线程处理
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/12/25 18:28
 */
public class SingleThread {
    public static long[] numbers;

    public static void main(String[] args) {
        numbers = LongStream.rangeClosed(1, 10_000_000).toArray();
        long sum = 0;
        for (long number : numbers) {
            sum += number;
        }
        System.out.println("sum  = " + sum);
    }
}
