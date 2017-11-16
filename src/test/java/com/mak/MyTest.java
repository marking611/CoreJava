package com.mak;

import org.junit.Test;

import java.util.*;

/**
 * Created by makai on 2017/10/30.
 */
public class MyTest {

//    public MyTest() {
//        new MyTest(true);
//    }
//
//    public MyTest(boolean p1) {
//        this.p1 = p1;
//    }

    boolean p1; //成员变量，编辑器会给与默认值

    @Test
    public void test01() throws Throwable {
        System.out.println(p1);
        /*
        //局部变量没有默认值，编译报错
        boolean p2;
        System.out.println(p2);
        */
    }

    @Test
    public void test02() {
        List<Integer> NumberList = new ArrayList<Integer>();
        NumberList.add(2);
        NumberList.add(4);
        NumberList.add(1);
        NumberList.add(3);
        NumberList.add(5);
        for (int i = 0; i < NumberList.size(); ++i) {
            int v = NumberList.get(i);
            if (v % 2 == 0) {
                NumberList.remove(v);
            }
        }
        System.out.println(NumberList);
    }

    @Test
    public void test03() {
        List<String> NumberList = new ArrayList<String>();
        NumberList.add("2");
        NumberList.add("4");
        NumberList.add("1");
        NumberList.add("3");
        NumberList.add("5");
        for (int i = 0; i < NumberList.size(); ++i) {
            String v = NumberList.get(i);
            if (Integer.valueOf(v) % 2 == 0) {
                NumberList.remove(v);
            }
        }
        System.out.println(NumberList);
    }

    @Test
    public void test05() {
        Long p1 = 1l;
        Integer p2 = 1;
        System.out.println(p1.equals(p2));
    }

    @Test
    public void test06() {
        m(1);
    }

    public void m(int i) {
        System.out.println("int");
    }

    public void m(Integer i) {
        System.out.println("integer");
    }

    @Test
    public void test07() {
        Finalize finalize = new Finalize();
        finalize = null; //释放
        Runtime.getRuntime().gc(); //通知gc回收
    }

    @Test
    public void test08() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "a");
        map.put("s", "s");
        Iterator<String> set = map.keySet().iterator();
        while (set.hasNext()) {
            String s = set.next();
            if (s.equals("s")) {
                map.remove("s");
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
            if (integer == 2)
                list.remove(integer);
        }
    }

}

class Finalize {
    public Finalize() {
        System.out.println("init");
    }

    protected void finalize() {
        System.out.println("销毁");
    }
}

interface Idefult {
    String s = "defult";
}

class Cdefult implements Idefult {

    static int i1 = 1;
    int i2 = 2;

    public static void main(String[] args) {
        Cdefult cdefult = new Cdefult();
    }
}

class T {
    private StringBuffer sb = new StringBuffer("a");

    public StringBuffer getSb() {
        try {
            sb.append("b");
            return sb;
        } finally {
            setSb("c");
        }
    }

    public void setSb(String sb) {
        this.sb.append(sb);
    }

    public static void print() {
        System.out.println("print");
    }

    public static void main(String[] args) {

        ((T) null).print();

//        System.out.println(new T().getSb().toString());
    }
}

class Base {
    Base() {
        this(1);
        new Base(2);
    }

    Base(int a) {
    }

    public Base(String s) {
        System.out.print("B");
    }
}

class Derived extends Base {
    public Derived(String s) {
        super(s); //子类构造方法在调用时必须先调用父类的，由于父类没有无参构造，必须在子类中显式调用
        System.out.print("D");
    }

    public static void main(String[] args) throws InterruptedException {
        new Derived("C");
    }

}

abstract class ABS {

    public static void main(String[] args) {
        ABS abs = new ABS() {
        };

        INT INT = new INT() {
        };
    }
}

interface INT {
}

class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        final Object o = new Object();
//        final Thread current = Thread.currentThread();
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("睡醒了");
                synchronized (o) {
                    o.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable).start();

        synchronized (o) {
            System.out.println("等待中。。。");
            o.wait();
            o.notify();
            System.out.println("执行结束");
        }


    }
}

class Block {
    int a;
    static int b;
    final int c = 1;
    public static Block t1 = new Block();

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args) {
        Block t2 = new Block();
    }
}

class Parent {
    public String name = "Bob";
    public int age = 35;
    private Object partner = new Object();

    public String hobby() {
        System.out.println(partner);
        return "football";
    }

    private String work() {
        return "IT";
    }
}

class Child extends Parent {
    public String name = "Tom";
    public int age = 5;

    static {
        System.out.println("this is static");
    }

    {
        System.out.println("this is low");
    }

    public static void main(String... args) throws Exception {
//        Class cla = Class.forName("com.mak.Child");
//        Method[] decMs =  cla.getDeclaredMethods();
//        Method[] ms = cla.getMethods();
//        Method encMs = cla.getEnclosingMethod();
//
//        Field[] fields = cla.getFields();
//        Field[] declds = cla.getDeclaredFields();
//        System.out.println();
//        Child child = new Child();
//        child.hobby();
        System.out.println();
    }
}

class NullTest {
    public static void print() {
        System.out.println("print");
    }

    public static void main(String... args) {
        NullTest test = null;
//        test.print();

        NullTest test2 = (NullTest) null;
        test2.print();
    }
}

class X {

    public X() {
        System.out.print("X");
    }

    Y y = new Y("x");
}

class Y {
    public Y(String p) {
        System.out.print(p);
    }
}

class Z extends X {

    public Z() {
        System.out.print("Z");
    }

    Y y = new Y("z");

    public static void main(String[] args) {
        new Z();
    }
}

enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}
class EnumOne
{
    public static void main(String[]args) throws ClassNotFoundException {
        Class.forName("com.mak.AccountType");
//        System.out.println(AccountType.FIXED);
    }
}

class BaseS{
    private String a = "123";
    public BaseS(){
        super();
        m();
    }
    public void m(){
        System.out.println(a);
    }
}

class Sub extends BaseS{
    private String a = "abc";
    public Sub() {
        super();
    }
    public void m(){
        System.out.println(a);
    }


    public static void main(String[] args){
        BaseS s = new Sub();
    }
}



