package com.mak.design_model.proxy;

/**
 * 真实主题角色
 * Created by makai on 2017/10/9.
 */
public class RealMyBase implements MyBase {
    @Override
    public void print() {
        System.out.println("RealMyBase.print");
    }
}
