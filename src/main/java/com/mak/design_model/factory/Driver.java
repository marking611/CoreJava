package com.mak.design_model.factory;

/**
 * Created by makai on 2017/8/2.
 */
public class Driver {
    public static void main(String[] args){
        Factory factory = new AudiFactory();
        Car car = factory.getCar();
        car.driver();
    }
}

