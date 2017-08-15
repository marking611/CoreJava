package com.mak.design_model.corp.sell;

/**
 * CEO 55%
 * Created by Administrator on 2017/8/15 0015.
 */
public class CEO extends PriceHandle {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.55){
            System.out.format("%s批准了折扣:%.2f%n",this.getClass().getName(),discount);
        }else{
            System.out.format("%s拒绝了折扣:%.2f%n",this.getClass().getName(),discount);
        }
    }
}
