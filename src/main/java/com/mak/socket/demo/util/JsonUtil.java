package com.mak.socket.demo.util;

import com.mak.socket.demo.domain.ChatAccount;
import net.sf.json.JSONObject;

import java.util.Arrays;

/**
 * Created by makai on 2017/9/15.
 */
public final class JsonUtil {
    private JsonUtil(){}

    private static final String STATUS = "status";
    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 250;
    private static final String MESSAGE = "message";
    private static final String SUCCESS = "操作成功";
    private static final String ERROR = "操作失败";

    public static final String success(){
        return success(SUCCESS);
    }

    public static final String success(String message){
        return success(message,null);
    }

    public static final String success(Object data){
        return success(SUCCESS,data);
    }

    public static final String success(String message,Object data){
        return result(SUCCESS_CODE,message,data);
    }


    public static final String error(){
        return error(ERROR);
    }

    public static final String error(String message){
        return error(message,null);
    }

    public static final String error(Object data){
        return error(ERROR,data);
    }

    public static final String error(String message,Object data){
        return result(ERROR_CODE,message,data);
    }

    private static final String result(int code,String message,Object data){
        JSONObject json = new JSONObject();
        json.put(STATUS,code);
        json.put(MESSAGE,message);
        json.put("data",data);
        return json.toString();
    }

    public static void main(String[] args){
        ChatAccount account = new ChatAccount();
        account.setAccount("asd");
        account.setSalt("1234");
        Arrays.asList(account);
        System.out.println(success(account));
    }

}
