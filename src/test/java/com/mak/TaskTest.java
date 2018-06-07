package com.mak;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by makai on 2018/3/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoreJavaApplication.class)
public class TaskTest {
    @Autowired
    private TaskA taskA;

    @Test
    public void test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        taskA.cron = "0 0/1 12-23 * * ?";
    }

    @Test
    public void test2() throws Exception {
        Vector<String> t1 = new Vector<>();
        t1.addAll(Arrays.asList("这个", "中文分词", "可不可以", "用着", "方", "不", "方便"));
        Vector<String> t2 = new Vector<>();
        t2.addAll(Arrays.asList("这个", "中文分词", "比较方便", "用着", "方便", "还可以"));
        System.out.println(getSimilarity(t1, t2));
    }

    public static double YUZHI = 0.2;

    public static double getSimilarity(Vector<String> T1, Vector<String> T2) throws Exception {
        int size, size2;
        if (T1 != null && (size = T1.size()) > 0 && T2 != null && (size2 = T2.size()) > 0) {

            Map<String, double[]> T = new HashMap<>();

            //T1和T2的并集T
            String index;
            for (int i = 0; i < size; i++) {
                index = T1.get(i);
                if (index != null) {
                    double[] c = T.get(index);
                    c = new double[2];
                    c[0] = 1;    //T1的语义分数Ci
                    c[1] = YUZHI;//T2的语义分数Ci
                    T.put(index, c);
                }
            }

            for (int i = 0; i < size2; i++) {
                index = T2.get(i);
                if (index != null) {
                    double[] c = T.get(index);
                    if (c != null && c.length == 2) {
                        c[1] = 1; //T2中也存在，T2的语义分数=1
                    } else {
                        c = new double[2];
                        c[0] = YUZHI; //T1的语义分数Ci
                        c[1] = 1; //T2的语义分数Ci
                        T.put(index, c);
                    }
                }
            }

            //开始计算，百分比
            Iterator<String> it = T.keySet().iterator();
            double s1 = 0, s2 = 0, Ssum = 0;  //S1、S2
            while (it.hasNext()) {
                double[] c = T.get(it.next());
                Ssum += c[0] * c[1];
                s1 += c[0] * c[0];
                s2 += c[1] * c[1];
            }
            //百分比
            return Ssum / Math.sqrt(s1 * s2);
        } else {
            throw new Exception("传入参数有问题！");
        }
    }
}


