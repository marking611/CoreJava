package com.mak.socket.demo.service;

import com.mak.socket.demo.domain.ChatAccount;
import com.mak.socket.demo.exception.ServiceException;
import com.mak.socket.demo.repository.ChatAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/14 0014.
 */
@Service
public class ChatAccountService {
    @Autowired
    private ChatAccountRepository accountRepository;

    @Transactional
    public String save(String account,String password){
        ChatAccount ca = new ChatAccount();
        ca.setAccount(account);
        try {
            accountRepository.save(ca);
        } catch (Exception e) {
            throw new ServiceException();
        }
        return null;
    }
}
