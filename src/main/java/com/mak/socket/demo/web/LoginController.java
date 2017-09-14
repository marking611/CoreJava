package com.mak.socket.demo.web;

import com.mak.socket.demo.service.ChatAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册 登录 退出
 * Created by Administrator on 2017/9/14 0014.
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private ChatAccountService accountService;

    /**
     * 注册
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/register")
    public String register(String account,String password){
        return accountService.save(account,password);
    }

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(String account,String password){
        return null;
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        return null;
    }
}
