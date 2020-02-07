package com.example.demo.multithreading.executor;

import java.util.concurrent.*;

/**
 * 线程池框架executor示例
 *
 * @author ywb
 * @date 2020/2/7 18:00
 */
public class ExecutorDemo {
    /**
     * 自定义线程名方式1
     */
    private static ThreadFactory threadFactory = r -> new Thread(r, "t_pl_pool_" + r.hashCode());

    public static ThreadPoolExecutor executePool = new ThreadPoolExecutor(50, 200, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5000), threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());

    /**
     * 自定义线程名方式2：在线程方法中设置名称
     */
    static class TestCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.currentThread().setName("test");
            return "test call";
        }
    }
}
