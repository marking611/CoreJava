package com.mak.socket.demo.util;

import java.security.MessageDigest;

/**
 * MD5加密
 * Created by makai on 2017/9/15.
 */
public final class MD5Util {
    //私有构造方法
    private MD5Util() {
    }

    /**
     * 加密2次
     *
     * @param s
     * @return
     */
    public final static String md5x2(String s) {
        return md5(md5(s));
    }

    /**
     * 加密
     *
     * @param s
     * @return
     */
    public final static String md5(String s) {

        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println(MD5Util.md5("12345678"));
    }
}
