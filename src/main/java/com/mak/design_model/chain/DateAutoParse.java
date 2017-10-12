package com.mak.design_model.chain;

/**
 * 具体处理者角色（时间）
 * Created by makai on 2017/10/10.
 */
public class DateAutoParse implements AutoParse {

    private AutoParse next;

    public void setNext(AutoParse next) {
        this.next = next;
    }

    public AutoParse getNext() {
        return next;
    }

    @Override
    public String[] autoParse(String[] code) {
        String[] newCode = new String[code.length+1];
        for (int i = 0; i < code.length; i++) {
            newCode[i] = code[i];
        }
        newCode[newCode.length-1] = "时间处理";
        if (next != null){
            return next.autoParse(newCode);
        }else{
            return newCode;
        }
    }
}
