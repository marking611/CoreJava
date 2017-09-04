package com.mak.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by makai on 2017/9/4.
 */
public class UDPSocketServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
            socket.receive(packet); //接收数据包 [堵塞]
            Thread thread = new Thread() {
                @Override
                public void run() {
                    //打印数据包数据
                    System.out.println("我是服务端，客户端说：" + new String(packet.getData(),0,packet.getLength()));
                    //向客户端回复信息
                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();
                    byte[] data2 = "连接成功！欢迎您！".getBytes();
                    DatagramPacket packet2 = new DatagramPacket(data2,0,data2.length,address,port);
                    try {
                        socket.send(packet2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }
}
