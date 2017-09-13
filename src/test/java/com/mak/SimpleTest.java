package com.mak;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public void obj(){
        a a = new a();
        a.setName("中软");
        a.setAge(10);
        System.out.println(a);
        Map map = new HashMap();
        map.put("a",a);
        a aa = (com.mak.a) map.get("a");
        System.out.println(aa);
        aa.setName("人民日报");
        aa.setAge(100);
        System.out.println(a.equals(aa));
        System.out.println(a==aa);
        System.out.println(a.hashCode()==aa.hashCode());
    }
}

class a{
    String name;
    int age;

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
}
