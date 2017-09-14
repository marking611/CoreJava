package com.mak.socket.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by makai on 2017/9/14.
 */
@Entity
@Table(name = "chat_account")
public class ChatAccount {
    @Id
    private String id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "account")
    private String account;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}