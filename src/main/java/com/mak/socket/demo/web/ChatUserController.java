package com.mak.socket.demo.web;

import com.mak.socket.demo.common.Constant;
import com.mak.socket.demo.domain.ChatUser;
import com.mak.socket.demo.service.ChatUserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/9/17 0017.
 */
@RestController
@RequestMapping("/user")
public class ChatUserController {
    @Autowired
    private ChatUserService userService;

    /**
     * 用户详细信息
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("detail")
    public String detail(String userId,HttpServletRequest request){
        if (StringUtils.isBlank(userId)){
            ChatUser cu = ((ChatUser) request.getSession().getAttribute(Constant.SESSION_USER));
            userId = cu == null ? null : cu.getId();
        }
        return userService.detail(userId);
    }

    /**
     * 用户信息修改
     * @param nickname
     * @param name
     * @param sex
     * @param age
     * @param headimg
     * @param request
     * @return
     */
    @RequestMapping("/info")
    public String info(String nickname, String name, int sex, int age, String headimg, HttpServletRequest request){
        HttpSession session = request.getSession();
        return userService.info(nickname,name,sex,age,headimg,session);
    }
}
