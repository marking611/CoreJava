package com.mak;

/**
 * Created by makai on 2018/5/17.
 */
public abstract class AbstractClass {
    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass() {};

        InterfaceClass interfaceClass = new InterfaceClass() {};

        ok:for (int i = 0; i < 10; i++) {
            bk:for (int j = 0; j < 10; j++) {
                if (i*j == 5) break ok;
            }
            System.out.println(i);
        }
    }

    interface InterfaceClass{

    }
}
