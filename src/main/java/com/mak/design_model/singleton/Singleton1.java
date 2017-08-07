package com.mak.design_model.singleton;

/**
 * 饿汉式
 * Created by Administrator on 2017/8/6 0006.
 */
public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance(){
        return singleton;
    }
}
