package com.mak.socket.demo.repository;

import com.mak.socket.demo.domain.ChatAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by makai on 2017/9/14 0014.
 */
public interface ChatAccountRepository extends CrudRepository<ChatAccount,String> {
    ChatAccount findByAccount(String account);
}
