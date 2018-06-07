package com.mak;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by makai on 2018/4/28.
 */
public class CallableTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable callable = new Callable() {
            @Override
            public A call() throws Exception {
                System.out.println("进入call。。。");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("结束call。。。");
                return new A();
            }
        };
        FutureTask task = new FutureTask(callable);
        new Thread(task).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程");
        if (!task.isDone()){
            System.out.println("还未结束");
        }
        task.get();
        System.out.println("结束了");

    }

    static class A{

    }
}
