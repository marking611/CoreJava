package com.mak;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by makai on 2017/12/1.
 */
public class OOMTest {
    @Test
    public void HeapOOM(){
        List list = new ArrayList();
        long i = 0;
        while (true){
            list.add(i++);
            System.out.println(i);
        }
    }
}
