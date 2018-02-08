package com.mak;

import org.junit.Test;

/**
 * 并发编程
 * Created by makai on 2018/2/8.
 */
public class TestConcurrent {
    static int count;

    @Test
    public void test01() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            testCount();
        }
    }

    public void testCount() throws InterruptedException {
        count = 0;
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
//                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 100; j++) {
                    inc();
                }
                System.out.print(count + "  ");
            }).start();
        }
        Thread.sleep(2000);
//        TimeUnit.SECONDS.sleep(2);
        System.out.println("count=" + count);
    }
    public synchronized void inc(){
        count++;
    }

}
