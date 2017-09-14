package com.mak.socket.demo.repository;


import com.mak.socket.demo.domain.ChatUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/14 0014.
 */
public interface ChatUserRepository extends CrudRepository<ChatUser,String>{
}
