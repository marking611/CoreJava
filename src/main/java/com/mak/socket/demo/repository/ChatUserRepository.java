package com.mak.socket.demo.repository;


import com.mak.socket.demo.domain.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/14 0014.
 */
@Repository
public interface ChatUserRepository extends CrudRepository<ChatUser,String>{
}
