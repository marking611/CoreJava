package com.mak.socket.demo.service;

import com.mak.socket.demo.common.Constant;
import com.mak.socket.demo.domain.ChatAccount;
import com.mak.socket.demo.domain.ChatUser;
import com.mak.socket.demo.exception.ServiceException;
import com.mak.socket.demo.repository.ChatAccountRepository;
import com.mak.socket.demo.repository.ChatUserRepository;
import com.mak.socket.demo.util.JsonUtil;
import com.mak.socket.demo.util.MD5Util;
import com.mak.socket.demo.util.RandomUtil;
import com.mak.socket.demo.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by makai on 2017/9/14 0014.
 */
@Service
public class ChatAccountService {
    @Autowired
    private ChatAccountRepository accountRepository;
    @Autowired
    private ChatUserRepository userRepository;

    /**
     * 新增（注册）帐号
     *
     * @param account
     * @param password
     * @return
     */
    @Transactional
    public String register(String account, String password, HttpSession session) {
        ChatAccount ca = accountRepository.findByAccount(account);
        if (ca != null) return JsonUtil.error("该账号已被注册");
        ca = new ChatAccount();
        ca.setId(UUIDUtil.get32UpperUUID());
        ca.setAccount(account);
        ca.setRegisterTime(new Date());
        String salt = RandomUtil.getNumStr(4);
        ca.setSalt(salt);
        password = MD5Util.md5x2(password + "-" + salt);
        ca.setPassword(password);
        try {
            accountRepository.save(ca);
            session.setAttribute(Constant.SESSION_ACCOUNT, ca);
            session.setAttribute(Constant.SESSION_USER, null);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return JsonUtil.success("注册成功");
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
    public String login(String account, String password, HttpSession session) {
        ChatUser user = null;
        try {
            ChatAccount ca = accountRepository.findByAccount(account);
            if (ca == null) return JsonUtil.error("用户不存在");
            //判断密码正确性
            String pass = MD5Util.md5x2(password + "-" + ca.getSalt());
            if (!pass.equals(ca.getPassword())) return JsonUtil.error("密码错误");
            session.setAttribute(Constant.SESSION_ACCOUNT, ca);
            //获取用户信息
            if (StringUtils.isBlank(ca.getUserId())) {
                session.setAttribute(Constant.SESSION_USER, null);
            } else {
                user = userRepository.findOne(ca.getUserId());
                session.setAttribute(Constant.SESSION_USER, user);
            }

        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return JsonUtil.success("登录成功", user);
    }

}
