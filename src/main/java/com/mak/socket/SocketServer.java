package com.mak.socket;

import java.io.*;
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
        //调用accept() 开始监听，等待客户端连接
        Socket socket = serverSocket.accept();
        //获取输入流，读取客户端信息
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is,"utf-8");
        BufferedReader reader = new BufferedReader(isr);
        String date = reader.readLine();
        while (date != null){
            System.err.println("【服务端】客户端说："+date);
            date = reader.readLine();
        }
        //关闭输入流
        socket.shutdownInput();

        //获取输出流，响应客户端请求
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("欢迎");
        pw.flush();

        //关闭资源
        pw.close();
        os.close();
        reader.close();
        isr.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        server();
    }
}
