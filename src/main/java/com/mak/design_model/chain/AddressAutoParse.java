package com.mak.design_model.chain;

/**
 * Created by makai on 2017/10/10.
 */
public class AddressAutoParse implements AutoParse {
    private AutoParse next;

    public AutoParse getNext() {
        return next;
    }

    public void setNext(AutoParse next) {
        this.next = next;
    }

    @Override
    public String[] autoParse(String[] code) {
        String[] newCode = new String[code.length+1];
        for (int i = 0; i < code.length; i++) {
            newCode[i] = code[i];
        }
        newCode[newCode.length-1] = "地址处理";
        if (next != null){
            return next.autoParse(newCode);
        }else{
            return newCode;
        }
    }
}
