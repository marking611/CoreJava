package com.mak;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 语法糖测试
 * Created by makai on 2018/3/20.
 */
@SpringBootTest
public class SugarTest {
    //泛型
    @Test
    public void genericity(){
        List list = new ArrayList();
        list = null;
    }
}

class Genericity{
    //编译不通过，因为在编辑时，会擦出泛型 method(List list)
    /*public static void method(List<Integer> list){}
    public static void method(List<String> list){}*/

}
