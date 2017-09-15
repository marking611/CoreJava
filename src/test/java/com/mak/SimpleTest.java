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
}

