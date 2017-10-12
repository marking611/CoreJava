package com.mak.design_model.iterator;

/**
 * 迭代器角色
 * Created by makai on 2017/10/11.
 */
public interface Iterator {
    boolean hadNext();
    Object next();
    void remove();
}
