package com.mak.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by makai on 2017/9/4.
 */
public class UDPSocketClient {
    public static void main(String[] args) throws IOException {
        //发送请求
        byte[] bytes = "UDP客户端002".getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 8888);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet); //发送数据包

        //接收请求
        byte[] data2 = new byte[1024];
        DatagramPacket packet2  = new DatagramPacket(data2,data2.length);
        socket.receive(packet2); //接收数据包
        //打印数据包信息
        System.out.println("我是客户端，服务端说："+new String(packet2.getData()));

    }
}
