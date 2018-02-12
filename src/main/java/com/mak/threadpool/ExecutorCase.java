package com.mak.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by makai on 2018/2/12.
 */
public class ExecutorCase {
    private static Executor executor = Executors.newFixedThreadPool(10);
}
