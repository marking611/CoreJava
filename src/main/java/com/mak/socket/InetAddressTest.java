package com.mak.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class InetAddressTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(InetAddressTest.class);
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress
        InetAddress address = InetAddress.getLocalHost();
        LOGGER.info(address.getHostName()); //机器名
        LOGGER.info(address.getHostAddress()); //ip
    }
}
