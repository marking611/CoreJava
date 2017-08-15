package com.mak.design_model.corp.sell;

/**
 * Created by Administrator on 2017/8/15 0015.
 */
public class Lead extends PriceHandle {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.15){
            System.out.format("%s批准了折扣:%.4%n",this.getClass().getName(),discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
