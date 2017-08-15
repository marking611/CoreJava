package com.mak.design_model.corp.sell;

/**
 * 经理 30%
 * Created by Administrator on 2017/8/15 0015.
 */
public class Manager extends PriceHandle {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.3){
            System.out.format("%s批准了折扣:%.2f%n",this.getClass().getName(),discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
