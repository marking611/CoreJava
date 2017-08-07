package com.mak.design_model.singleton;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/6 0006.
 */
public class Singleton3 {
    public static HashMap map = new HashMap();
    protected Singleton3(){}
    public static Singleton3 getInstance(String name){
        if (name == null){
            name = "Singleton3";
        }
        if (map.get(name) == null){
            try {
                map.put(name,Class.forName("com.mak.design_model.singleton."+name).newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return (Singleton3) map.get(name);
    }
    public void test(){
        System.out.println("测试方法：Singleton3");
    }
}

class Singleton3c extends Singleton3{
    public static Singleton3c getInstance(String name){
        return (Singleton3c) Singleton3.getInstance(name);
    }
    public void test(){
        System.out.println("测试方法：Singleton3c");
    }
}

class SingletonMain{
    public static void main(String[] args){
        Singleton3 singleton3 = Singleton3.getInstance(null);
        singleton3.test();

        Singleton3c singleton3c = Singleton3c.getInstance("Singleton3c");
        singleton3c.test();
    }
}
