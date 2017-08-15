package com.mak.design_model.corp.sell;

import java.util.Random;

/**
 * 客户 申请折扣
 * Created by Administrator on 2017/8/15 0015.
 */
public class Customer {
    private PriceHandle priceHandle;
    public void setPriceHandle(PriceHandle priceHandle) {
        this.priceHandle = priceHandle;
    }
    public void requestDiscount(float discount){
        priceHandle.processDiscount(discount);
    }

    public static void main(String[] args){
        Customer customer = new Customer();
        customer.setPriceHandle(PriceHandleFactory.createPriceHandle());
        customer.requestDiscount(new Random().nextFloat());
    }
}
