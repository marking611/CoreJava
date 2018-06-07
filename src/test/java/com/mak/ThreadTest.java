package com.mak;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by makai on 2018/4/18.
 */
public class ThreadTest {
    @Test
    public void test01() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0 ;i < 100;i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("------------");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0 ;i < 100;i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("++++++++++++++");
            }
        });
        thread.start(); //thread 线程启动
        thread2.start(); //thread2 线程启动
        thread.join(); //主线程获取cpu后，主动放弃，直到thread执行完毕
        thread2.join(); //主线程获取cpu后，主动放弃，知道thread2执行完毕
    }
}
