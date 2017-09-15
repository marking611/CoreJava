package com.mak.socket.demo.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 生成随机串
 * Created by makai on 2017/9/15.
 */
public final class RandomUtil {
    private RandomUtil(){}
    private static final char[] NUMBER = {'0','1','2','3','4','5','6','7','8','9'};
    private static final char[] LETTER_LOWER = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static final char[] LETTER_UPPER = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    /**
     * 获取指定长度的数字字符串
     * @param len
     * @return
     */
    public static final String getNumStr(int len){
        return getStr(NUMBER,len);
    }

    /**
     * 获取指定长度的小写字母字符串
     * @param len
     * @return
     */
    public static final String getLetterLowerStr(int len){
        return getStr(LETTER_LOWER,len);
    }

    /**
     * 获取指定长度的大写字母字符串
     * @param len
     * @return
     */
    public static final String getLetterUpperStr(int len){
        return getStr(LETTER_UPPER,len);
    }

    /**
     * 获取指定长度的字母字符串（大小写混合）
     * @param len
     * @return
     */
    public static final String getLetterStr(int len){
        return getStr(ArrayUtils.addAll(LETTER_LOWER,LETTER_UPPER),len);
    }
    /**
     * 获取指定长度的字符串（数字+字母）
     * @param len
     * @return
     */
    public static final String getStr(int len){
        return getStr(ArrayUtils.addAll(NUMBER,ArrayUtils.addAll(LETTER_UPPER,LETTER_LOWER)),len);
    }




    /**
     * 获取指定长度的随机字符串
     * @param chars
     * @param len
     * @return
     */
    private static final String getStr(char[] chars,int len){
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < len){
            sb.append(chars[(int)(Math.random()*chars.length)]);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(getNumStr(4));
        System.out.println(getStr(6));
        System.out.println(getLetterStr(8));

    }

}
