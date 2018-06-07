package com.mak.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * Created by makai on 2018/5/16.
 */
public class Reflect01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class demo = Class.forName("com.mak.reflect.Demo01");
        Constructor[] constructors = demo.getConstructors();
        for (Constructor constructor :constructors){
            Parameter[] parameters = constructor.getParameters();
            Object[] param = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                Class type = parameters[i].getType();
                if (type.getName().equals("java.lang.String")){
                    param[i] = "你好";
                }else if (type.getName().equals("int") || type.getName().equals("java.lang.Integer")){
                    param[i] = 23;
                }
            }
            Object o = constructor.newInstance(param);
            System.out.println(o);
        }

    }
}
