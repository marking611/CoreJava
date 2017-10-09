package com.mak.design_model.proxy;

/**
 * 代理主题角色
 * Created by makai on 2017/10/9.
 */
public class ProxyMyBase implements MyBase {
    private RealMyBase realMyBase = new RealMyBase();
    private boolean result;

    public ProxyMyBase(boolean result) {
        this.result = result;
    }

    @Override
    public void print() {
        if (result){
            realMyBase.print();
        }else{
            System.out.println("ProxyMyBase.print");
        }
    }
}
