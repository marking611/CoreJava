package com.mak.socket;

import java.io.IOException;
import java.net.*;

/**
 * Created by makai on 2017/9/4.
 */
public class UDPSocketClient {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "UDP客户端001".getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,8899);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet); //发送数据包
        socket.close();

    }
}
