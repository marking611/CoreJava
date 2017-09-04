package com.mak.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 ① 创建ServerSocket对象，绑定监听端口
 ② 通过accept()方法监听客户端请求
 ③ 连接建立后，通过输入流读取客户端发送的请求信息
 ④ 通过输出流向客户端发送乡音信息
 ⑤ 关闭相关资源
 * Created by Administrator on 2017/8/29 0029.
 */
public class SocketServer {
    public static void server() throws IOException {
        //创建服务socket
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true){
            //调用accept() 开始监听，等待客户端连接 [阻塞]
            Socket socket = serverSocket.accept();
            ServerThread thread = new ServerThread();
            thread.socket = socket;
            thread.start();
        }

    }

    public static void main(String[] args) throws IOException {
        server();
    }
}
