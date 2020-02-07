package com.example.demo.multithreading.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池框架executor示例
 *
 * @author ywb
 * @date 2020/2/7 18:00
 */
public class ExecutorDemo {
    /**
     * 自定义线程名
     */
    private static ThreadFactory threadFactory = r -> new Thread(r, "t_pl_pool_" + r.hashCode());

    public static ThreadPoolExecutor executePool = new ThreadPoolExecutor(50, 200, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5000), threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
}
