package com.mak.socket;

import java.io.*;
import java.net.Socket;

/**
 ① 创建Socket对象，指明需要连接的服务器的地址和端口号
 ② 连接建立后，通过输出流想服务器端发送请求信息
 ③ 通过输入流获取服务器响应的信息
 ④ 关闭响应资源
 */
public class SocketClient {
    public static void client() throws IOException {
        //创建客户端
        Socket socket = new Socket("localhost",9999);
        //获取输出流
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("用户名：tom;密码：456");
        pw.flush();
        socket.shutdownOutput();

        //获取输入流
        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String date = reader.readLine();
        while (date != null){
            System.out.println("【客户端】服务端说："+date);
            date = reader.readLine();
        }

        //关闭资源
        reader.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        client();
    }
}
