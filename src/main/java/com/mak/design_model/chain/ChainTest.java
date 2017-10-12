package com.mak.design_model.chain;

/**
 * Created by makai on 2017/10/10.
 */
public class ChainTest {
    public static void main(String[] args){
        DateAutoParse date = new DateAutoParse();
        AddressAutoParse address = new AddressAutoParse();
        date.setNext(address);
        String[] result = date.autoParse(new String[]{});
        for (String s : result) {
            System.out.println(s);
        }
    }
}
