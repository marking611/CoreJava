package com.mak;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyTest2 {

    @Test
    public void testFinally(){
        System.out.println(finallyMethod());
    }

    private int finallyMethod(){
        int i = 2;
        try {
            return ++i;
        }finally {
            i = i*2; //打印 3
            System.out.println("finally 打印"+i);
//            return i; // 打印 6
        }
    }
}
