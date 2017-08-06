package com.mak.design_model.singleton;

/**
 * 懒汉式
 * Created by Administrator on 2017/8/6 0006.
 */
public class Singleton2 {
    private static Singleton2 singleton;
    private Singleton2(){}
    public synchronized static Singleton2 getInstance(){ //加锁：为了防止多线程环境中产生多个实例
        if (singleton == null){
            return new Singleton2();
        }
        return singleton;
    }
}
