package com.mak.socket.demo.util;

import java.util.UUID;

/**
 * UUID 工具类
 * Created by Administrator on 2017/9/14 0014.
 */
public class UUIDUtil {
    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    public static String get32UpperUUID() {
        return get32UUID().toUpperCase();
    }

    public static String getLowerUUID() {
        return get32UUID().toLowerCase();
    }

    public static String get64UUID() {
        String uuid = (UUID.randomUUID().toString() + UUID.randomUUID().toString()).replaceAll("-", "");
        return uuid;
    }

    public static String get64UpperUUID() {
        return get64UUID().toUpperCase();
    }

    public static String get64LowerUUID() {
        return get64UUID().toLowerCase();
    }
}
