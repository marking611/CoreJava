package com.mak;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
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

    @Test
    public void test(){
        P c1 = new S();
        System.out.println(c1.cc);
        System.out.println(P.c);
        c1.m2();
        System.out.println("------------");
        S c2 = new S();
        System.out.println(c2.cc);
        System.out.println(S.c);
    }

    @Test
    public void test2(){
        String str1 = new String("ab");
        String str2 = new String("ab");
        String str3 = "a";
        String str4 = "b";
        String str5 = str3 + str4;
        System.out.println(str1.intern() == str2.intern());
        System.out.println(str5.intern() == str1);
    }



    private static final byte[] USER_PASSWORD_KEY = { 64, 11, -110, 11, 107, -2, -12, -83, 88, -118, 91, 84, 47, 84, 76, 98, 110, 84, -14, -48, 121, -14, 69, -94 };

    private final String algorithm = "DESede";
    private final SecretKey secretKey1 = new SecretKeySpec(USER_PASSWORD_KEY, "DESede");

    String decrypt(String encryptString)
    {
        encryptString = encryptString.substring(5, encryptString.length() - 5);

        String result = null;
        try
        {
            byte[] encryptByte = hex2byte(encryptString);

            Cipher c1 = Cipher.getInstance("DESede");
            c1.init(2, this.secretKey1);
            byte[] clearByte = c1.doFinal(encryptByte);

            result = new String(clearByte);
        }
        catch (Exception localException)
        {
        }

        return result;
    }

    private byte[] hex2byte(String hex)
    {
        byte[] _byte = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length() / 2; i++)
        {
            _byte[i] = ((byte)Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16));
        }

        return _byte;
    }

    @Test
    public void test03(){
        System.out.println(decrypt("3DES{10E97C22BC218C58}===="));
    }
}

class P{
    public static String c = "P";
    public String cc = "PP";

    public static void m1(){
        System.out.println("A static m1");
    }

    public  void m2(){
        System.out.println("A no static m2");
    }
}
class S extends P{
    public static String c = "S";
    public String cc = "SS";

    @Override
    public void m2() {
        System.out.println("a no static m2");
    }

//    public static void m1(){
//        System.out.println("a static m1");
//    }
}

