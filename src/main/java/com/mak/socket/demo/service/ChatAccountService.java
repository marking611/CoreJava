package com.mak.socket.demo.service;

import com.mak.socket.demo.domain.ChatAccount;
import com.mak.socket.demo.exception.ServiceException;
import com.mak.socket.demo.repository.ChatAccountRepository;
import com.mak.socket.demo.util.JsonUtil;
import com.mak.socket.demo.util.MD5Util;
import com.mak.socket.demo.util.RandomUtil;
import com.mak.socket.demo.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by makai on 2017/9/14 0014.
 */
@Service
public class ChatAccountService {
    @Autowired
    private ChatAccountRepository accountRepository;

    /**
     * 新增（注册）帐号
     *
     * @param account
     * @param password
     * @return
     */
    @Transactional
    public String save(String account, String password) {
        ChatAccount ca = accountRepository.findByAccount(account);
        if (ca == null) return JsonUtil.error("该账号已被注册");
        ca = new ChatAccount();
        ca.setId(UUIDUtil.get32UpperUUID());
        ca.setAccount(account);
        ca.setRegisterTime(LocalDateTime.now());
        String salt = RandomUtil.getNumStr(4);
        ca.setSalt(salt);
        password = MD5Util.md5x2(password + "-" + salt);
        ca.setPassword(password);
        try {
            accountRepository.save(ca);
        } catch (Exception e) {
            throw new ServiceException();
        }
        return JsonUtil.success("注册成功", ca);
    }

}
