package com.mak.up;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by makai on 2018/3/9.
 */
public class MapTest {
    public static void main(String[] args) {
        hashMap();
    }

    private static void hashMap() {
        Map<Object, Object> hashMap = new HashMap<>();
        hashMap.put("hashMap", "This is HashMap");

        Map<Object, Object> hashMap2 = new HashMap<>(3);
        hashMap2.put(1, 1);
        hashMap2.put(2, 2);
        hashMap2.put(3, 3);
        Set<Map.Entry<Object, Object>> entrySet2 = hashMap2.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet2) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

        Map<Object, Object> hashMap3 = new HashMap<>(hashMap);
        Set<Map.Entry<Object,Object>> entrySet3 =  hashMap3.entrySet();
        for (Map.Entry entry:entrySet3){
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
    }

    private static void concurrentHashMap() {
        Map<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("concurrentHashMap", "This is ConcurrentHashMap");
    }
}
