package com.example.demo.multithreading;

import java.util.stream.LongStream;

/**
 * 流方式
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/12/25 20:57
 */
public class StreamTest {
    public static void main(String[] args) {
        System.out.println("sum = " + parallelRangedSum(10_000_000));
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }
}
