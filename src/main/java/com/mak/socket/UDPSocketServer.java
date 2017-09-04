package com.mak.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by makai on 2017/9/4.
 */
public class UDPSocketServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8899);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
        while (true){
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        socket.receive(packet); //接收数据包[阻塞]
                        System.out.print("我是服务端，客户端说："+new String(bytes,"utf-8"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            thread.start();
        }
    }
}
