package com.mak.socket.demo.service;

import com.mak.socket.demo.common.Constant;
import com.mak.socket.demo.domain.ChatAccount;
import com.mak.socket.demo.domain.ChatUser;
import com.mak.socket.demo.exception.ServiceException;
import com.mak.socket.demo.repository.ChatAccountRepository;
import com.mak.socket.demo.repository.ChatUserRepository;
import com.mak.socket.demo.util.JsonUtil;
import com.mak.socket.demo.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/9/14 0014.
 */
@Service
public class ChatUserService {
    @Autowired
    private ChatUserRepository userRepository;
    @Autowired
    private ChatAccountRepository accountRepository;

    /**
     * 用户详细信息
     * @param userId
     * @return
     */
    public String detail(String userId){
        if (userId == null) return JsonUtil.success();
        ChatUser cu = userRepository.findOne(userId);
        return JsonUtil.success(cu);
    }

    /**
     * 用户信息修改
     * @param nickname
     * @param name
     * @param sex
     * @param age
     * @param headimg
     * @param session
     * @return
     */
    @Transactional
    public String info(String nickname, String name, int sex, int age, String headimg, HttpSession session){
        ChatUser cu = (ChatUser) session.getAttribute(Constant.SESSION_USER);
        try {
            if (cu == null){
                ChatAccount ca = (ChatAccount) session.getAttribute(Constant.SESSION_ACCOUNT);
                String userId = UUIDUtil.get32UpperUUID();
                cu = new ChatUser();
                cu.setId(userId);
                accountRepository.updateUserId(userId,ca.getId());
            }
            cu.setNickname(nickname);
            cu.setName(name);
            cu.setAge(age);
            cu.setSex(sex);
            cu.setHeadimg(headimg);
            userRepository.save(cu);
            session.setAttribute(Constant.SESSION_USER,cu);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return JsonUtil.success();
    }
}
