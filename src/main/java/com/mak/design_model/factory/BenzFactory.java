package com.mak.design_model.factory;

/**
 * Created by makai on 2017/8/2.
 */
public class BenzFactory implements Factory {
    @Override
    public Car getCar() {
        return new BenzCar();
    }
}
