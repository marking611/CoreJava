package com.mak.socket.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by makai on 2017/12/21.
 */
@Controller
public class SendMsgController {
    @Autowired
    MyWebSocket socket;

    @ResponseBody
    @RequestMapping("/sendMsg")
    public void sendMsg(String msg){
        socket.onMessage(msg);
    }
}
