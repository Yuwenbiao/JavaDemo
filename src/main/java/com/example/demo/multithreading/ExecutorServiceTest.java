package com.example.demo.multithreading;

import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 * 线程池方式
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/12/25 20:51
 */
public class ExecutorServiceTest {
    public static final int THRESHOLD = 10_000;
    public static long[] numbers;

    public static void main(String[] args) throws Exception {
        numbers = LongStream.rangeClosed(1, 10_000_000).toArray();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        CompletionService<Long> completionService = new ExecutorCompletionService<>(executor);

        int taskSize = numbers.length / THRESHOLD;
        for (int i = 1; i <= taskSize; i++) {
            final int key = i;
            completionService.submit(() -> sum((key - 1) * THRESHOLD, key * THRESHOLD));
        }

        long sumValue = 0;
        for (int i = 0; i < taskSize; i++) {
            sumValue += completionService.take().get();
        }
        // 所有任务已经完成,关闭线程池
        System.out.println("sumValue = " + sumValue);
        executor.shutdown();
    }

    private static long sum(int start, int end) {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
