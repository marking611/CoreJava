package com.mak;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by makai on 2017/9/8.
 */
public class SimpleTest {
    @Test
    public void parse() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String date = "2017";
        Date date1 = simpleDateFormat.parse(date);
        System.out.println(date1);
    }

    @Test
    public void testFinal(){
        String a = "h2";
        final String b = "h";
        String c = "h";
        String e = b+2;
        String f = c+2;
        System.out.println(a == e);
        System.out.println(a == f);
    }

    @Test
    public void test(){
        P c1 = new S();
        System.out.println(c1.cc);
        System.out.println(P.c);
        c1.m2();
        System.out.println("------------");
        S c2 = new S();
        System.out.println(c2.cc);
        System.out.println(S.c);
    }

    @Test
    public void test2(){
        String str1 = new String("ab");
        String str2 = new String("ab");
        String str3 = "a";
        String str4 = "b";
        String str5 = str3 + str4;
        System.out.println(str1.intern() == str2.intern());
        System.out.println(str5.intern() == str1);
    }
}

class P{
    public static String c = "P";
    public String cc = "PP";

    public static void m1(){
        System.out.println("A static m1");
    }

    public  void m2(){
        System.out.println("A no static m2");
    }
}
class S extends P{
    public static String c = "S";
    public String cc = "SS";

    @Override
    public void m2() {
        System.out.println("a no static m2");
    }

//    public static void m1(){
//        System.out.println("a static m1");
//    }
}

