package com.mak.reflect;

/**
 * Created by makai on 2018/5/16.
 */
public class Demo01 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Demo01() {
    }

    public Demo01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
