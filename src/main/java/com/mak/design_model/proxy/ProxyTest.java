package com.mak.design_model.proxy;

/**
 * Created by makai on 2017/10/9.
 */
public class ProxyTest {
    public static void main(String[] args){
        ProxyMyBase proxyMyBase = new ProxyMyBase(false);
        proxyMyBase.print();
    }
}
