package com.mak;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @Test
    public void testSubstring(){
        String a = "a.jpg";
        String b = "b";
        String c = ".c";
        String d = "d.";

        System.out.println(a.substring(0,a.lastIndexOf(".")));
        System.out.println(b.lastIndexOf("."));
        System.out.println(b.substring(0,b.lastIndexOf(".")));
        System.out.println(c.substring(0,c.lastIndexOf(".")));
        System.out.println(d.substring(0,d.lastIndexOf(".")));
    }

    @Test
    public void catTest(){
        WhiteCat wc = new WhiteCat();
        Animal a = wc;
        Cat c = wc;
        a.say(); // 白
        c.say(); // 白

        Cat c2 = (Cat) a;
        c2.say();
    }

    @Test
    public void testTrim(){
        String str = "你好吗？";
        System.out.println(str.trim());
        System.out.println(StringUtils.trimAllWhitespace(str));
        System.out.println(trim(str));
    }

    public String trim(String str) {
        char[] value = str.toCharArray();
        int len = value.length;
        int st = 0;
        char[] val = value;    /* avoid getfield opcode */

        while ((st < len) && (val[st] <= ' ' || val[st] <= '　')) {
            st++;
        }
        while ((st < len) && (val[len - 1] <= ' ' || val[len - 1] <= '　')) {
            len--;
        }
        return ((st > 0) || (len < value.length)) ? str.substring(st, len) : str;
    }

    @Test
    public  void writeWordFile() {

        boolean w = false;

        String path = "d:/";

        try {

            if (!"".equals(path)) {

                // 检查目录是否存在

                File fileDir = new File(path);

                if (fileDir.exists()) {

                    // 生成临时文件名称

                    String fileName = "a.doc";

                    String content = "<html><p style=\"text-align: center\"><span style=\"font-size: 28px\"><span style=\"font-family: 黑体\">" +

                            "制度发布通知<br /> <br /> </span></span></p></html>";

                    byte b[] = content.getBytes("gbk");

                    ByteArrayInputStream bais = new ByteArrayInputStream(b);

                    POIFSFileSystem poifs = new POIFSFileSystem();

                    DirectoryEntry directory = poifs.getRoot();

                    DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);

                    FileOutputStream ostream = new FileOutputStream(path+ fileName);

                    poifs.writeFilesystem(ostream);

                    bais.close();

                    ostream.close();

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return;

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

class Animal{
    public void say(){
        System.out.println("动物");
    }
}

class Cat extends Animal{
    @Override
    public void say() {
        System.out.println("猫");
    }
}

class WhiteCat extends Cat{
    @Override
    public void say() {
        System.out.println("白猫");
    }
}

class TestSync2 implements Runnable {
    int b = 100;

    synchronized void m1() throws InterruptedException {
        b = 1000;
        Thread.sleep(500); //6
        System.out.println("b=" + b);
    }

    synchronized void m2() throws InterruptedException {
        Thread.sleep(250); //5
        b = 2000;
    }

    public static void main(String[] args) throws InterruptedException {
        TestSync2 tt = new TestSync2();
        Thread t = new Thread(tt);  //1
        t.start(); //2
//        Thread.sleep(1);
        tt.m2(); //3
        System.out.println("main thread b=" + tt.b); //4
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
