package com.mak.design_model.corp.sell;

/**
 * 工厂类
 * Created by Administrator on 2017/8/15 0015.
 */
public class PriceHandleFactory {
    //利用直接后继将链连接起来
    public static PriceHandle createPriceHandle() {
        PriceHandle sales = new Sales();
        PriceHandle lead = new Lead();
        PriceHandle manager = new Manager();
        PriceHandle ceo = new CEO();
        sales.setSuccessor(lead);
        lead.setSuccessor(manager);
        manager.setSuccessor(ceo);
        return sales;
    }
}
