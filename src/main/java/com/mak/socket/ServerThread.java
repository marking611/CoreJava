package com.mak.socket;

import java.io.*;
import java.net.Socket;

/**
 * 利用多线程解决多可客户端问题
 * Created by makai on 2017/9/4.
 */
public class ServerThread extends Thread {
    Socket socket = null;


    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        try {
            //获取输入流，读取客户端信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader reader = new BufferedReader(isr);
            String date = reader.readLine();
            while (date != null) {
                System.err.println("【服务端】客户端说：" + date);
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
