package com.example.demo.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger示例
 *
 * @author ywb
 * @date 2020/2/20 12:10
 */
public class AtomicIntegerDemo {
    private static AtomicInteger atomicI = new AtomicInteger(0);

    public static void main(String[] args) {

    }

    /**
     * 使用CAS实现线程安全记数
     */
    private static void safeCountByCas() {
        for (; ; ) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    /**
     * 自增
     */
    private static void autoIncrement() {
        for (int m = 0; m < 1000000; m++) {
            atomicI.getAndIncrement();
        }
    }
}
