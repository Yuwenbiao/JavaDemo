package com.example.demo.multithreading.synchronize;

/**
 * Synchronized示例
 *
 * @author ywb
 * @date 2020/2/9 16:01
 */
public class SynchronizedDemo implements Runnable {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }

        //等待所有的线程执行完毕
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("result: " + count);
    }


    @Override
    public void run() {
        //Synchronized修饰一个代码块
        synchronized (this) {
            for (int i = 0; i < 1000000; i++) {
                count++;
            }
        }
    }

    /**
     * Synchronized作用于整个方法的写法
     */
    public synchronized void method() {
        // todo
    }

    /**
     * Synchronized也可修饰一个静态方法
     */
    public synchronized static void method2() {
        // todo
    }

    /**
     * Synchronized还可作用于一个类
     */
    public static void method3() {
        synchronized (SynchronizedDemo.class) {
            // todo
        }
    }
}
