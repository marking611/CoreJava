package com.mak.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by makai on 2018/2/12.
 */
public class ExecutorCase {
    //初始化包含10个线程的线程池
    private static Executor executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            executor.execute(new Task());
        }

    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
