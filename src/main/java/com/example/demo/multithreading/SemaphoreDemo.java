package com.example.demo.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量示例
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/1/19 13:37
 */
public class SemaphoreDemo {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(test);
        }
        threadPool.shutdown();
    }

    private static Runnable test = () -> {
        try {
            s.acquire();
            System.out.println("save data");
            s.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };
}
