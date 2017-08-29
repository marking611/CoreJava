package com.mak.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class URLTest {
    static Logger logger = LoggerFactory.getLogger(URLTest.class);
    public static void main(String[] args) throws IOException {
//        URL url = new URL("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504621236&di=ea9df15b556bcd241c2cb54a8c689608&imgtype=jpg&er=1&src=http%3A%2F%2Ffdfs.xmcdn.com%2Fgroup12%2FM04%2FE0%2FDD%2FwKgDW1aQ4bzCSzFHAACaqk2mBMY274.jpg");
//        logger.info(url.getProtocol()); //协议
//        logger.info(url.getHost()); //主机
//        logger.info(String.valueOf(url.getPort())); //端口
//        logger.info(url.getPath()); //文件路径
//        logger.info(url.getFile()); //文件名
//        logger.info(url.getRef()); //相对路径
//        logger.info(url.getQuery()); //参数

        //获取网页内容
        URL html = new URL("http://www.baidu.com");
        InputStream is = html.openStream(); // 获取资源的字节输入流
        InputStreamReader isr = new InputStreamReader(is,"utf-8");
        BufferedReader br = new BufferedReader(isr);
        String date = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (date != null){
            sb.append(date+"\n");
            date = br.readLine();
        }
        br.close();isr.close();is.close();
        System.out.println(sb.toString());

    }
}
