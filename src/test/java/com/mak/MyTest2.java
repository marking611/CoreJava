package com.mak;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class MyTest2 {

    @Test
    public void testFinally() {
        System.out.println(finallyMethod());
    }

    private int finallyMethod() {
        int i = 2;
        try {
            return ++i;
        } finally {
            i = i * 2; //打印 3
            System.out.println("finally 打印" + i);
//            return i; // 打印 6
        }
    }

    @Test
    public void testBasicVariable01() {
        Integer i = 10;
        Long l = 10l;
        Double d = 10.0;
        System.out.println(i.equals(l));
        System.out.println(i.equals(d));
        System.out.println(d.equals(l));
        System.out.println(l.equals(10L));
    }

    @Test
    public void testIf01() {
        int a = 3;
        int c = 1;
        if (a > 0)
            if (a > 3)
                c = 2;
            else
                c = 3;
        else
            c = 4;
    }

    @Test
    public void testReplace01() {
        System.out.println("com.mk.".replace(".", "/"));
        String classFile = "com.jd.".replaceAll(".", "/");
        System.out.println(classFile);
    }

    @Test
    public void testA() {
        BaseA base = new SubA();
        base.fun(1, 10);
        SubA sub = new SubA();
        sub.fun(2, 20);
    }

    @Test
    public void testi1() {
        int i = 0;
        i = i++;
        System.out.println(i);
    }

    @Test
    public void testj2() {
        int i = 0;
        int j = i++;
        System.out.println(i);
    }

    public volatile int a = 0;

    @Test
    public void testVolatile() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(++a);
            }).start();
        }
        TimeUnit.SECONDS.sleep(1l);
        System.out.println(a);
    }

    @Test
    public void testLambda(){
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        list.forEach(i->{
            if (i%2 == 0) return;
            System.out.println(i);
        });
    }
}

class BaseA {
    void fun(int i, int... array) {
        System.out.println("BaseA");
    }
}

class SubA extends BaseA {

    @Override
    void fun(int i, int... array) {
        System.out.println("SubA");
    }
}

interface InterfaceA {
    int k = 10;
}

class ClassA implements InterfaceA {
    public static void main(String args[]) {
        int i;
        ClassA a = new ClassA();
        i = a.k;
        System.out.println(i);
    }
}
