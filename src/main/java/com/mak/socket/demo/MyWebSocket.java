package com.mak.socket.demo;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by makai on 2017/9/13.
 */
@Component
@ServerEndpoint("/websocket")
public class MyWebSocket {
    /**
     * 记录当前在线连接数，
     * 应该设计成线程安全的
     */
    private static int onlineCount = 0;

    /**
     * concurrent包的线程安全set，
     * 用来存放每个客户端对应的WebSocket对象
     */
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 连接成功
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this); //加入set
        addOnlineCount(); //在线人数+1
        System.out.println("加入一个连接，现在在线人数："+onlineCount);
    }

    /**
     * 连接关闭调用方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this); //从set中移除
        subOnlineCount(); //在线人数-1
    }

    /**
     * 发送错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();
    }

    /**
     * 接收客户端消息
     *
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("接收到消息:" + message);

        //群发消息
        webSocketSet.forEach(myWebSocket -> {
            try {
                sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 发送消息
     * @param message
     * @throws IOException
     */
    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 在线人数自增1 （同步）
     */
    private synchronized void addOnlineCount(){
        onlineCount++;
    }

    /**
     * 在线人数自减1 （同步）
     */
    private synchronized void subOnlineCount(){
        onlineCount--;
    }
}
