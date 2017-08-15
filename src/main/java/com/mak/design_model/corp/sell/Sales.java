package com.mak.design_model.corp.sell;

/**
 * 销售 5%
 * Created by Administrator on 2017/8/15 0015.
 */
public class Sales extends PriceHandle {
    @Override
    public void processDiscount(float discount) {
        if (discount <= 0.05){
            System.out.format("%s批准了折扣:%.4%n",this.getClass().getName(),discount);
        }else{
            successor.processDiscount(discount);
        }
    }
}
