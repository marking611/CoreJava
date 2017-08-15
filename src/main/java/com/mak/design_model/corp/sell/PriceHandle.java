package com.mak.design_model.corp.sell;

/**
 * 价格处理人，负责处理客户折扣申请
 * Created by Administrator on 2017/8/15 0015.
 */
public abstract class PriceHandle {
    //直接后继（即后一个结点），用户传递请求
    protected  PriceHandle successor;
    public void setSuccessor(PriceHandle successor) {
        this.successor = successor;
    }
    
    //处理折扣申请
    public abstract void processDiscount(float discount);

}
