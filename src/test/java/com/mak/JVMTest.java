package com.mak;

import org.junit.Test;

/**
 * Created by makai on 2017/12/21.
 */
public class JVMTest {
    @Test
    public void test01(){
        System.out.println(A.i);
        A a = new A();
        System.out.println(a.i);
    }
}

class A{
    public static int i = 2;
    static {
        i++;
    }
}
