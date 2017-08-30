package com.mak.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by makai on 2017/8/30.
 */
public class FileChannelTest {
    public static void read() throws IOException {
        RandomAccessFile file = new RandomAccessFile("K:\\my\\mygit\\CoreJava\\doc\\eng.txt", "rw");

        FileChannel fc = file.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(48); //分配字节
        int byteRead = fc.read(bb); //向buffer写数据
        while (byteRead != -1) {
            System.out.println(byteRead);
            bb.flip(); //从写模式切换到读模式
            while (bb.hasRemaining()) {
                System.err.print(new String(new byte[]{bb.get()},"gbk")); //读取数据到channel
            }
            bb.clear(); //make buffer ready for writing
            byteRead = fc.read(bb);
        }
        fc.close();
        file.close();
    }

    public static void main(String[] args) throws IOException {
        read();
    }
}
