package com.mak.io;

import java.io.*;

/**
 * Created by makai on 2017/8/29.
 */
public class InputStreamTest {
    public String bufferRead(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str + "\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String stringRead(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            StringReader sr = new StringReader(this.fileRead(filename));
            int c;
            while ((c = sr.read()) != -1) {
                sb.append((char) c);
            }
            sr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String fileRead(String filename) {
        File file = new File(filename);
        StringBuilder sb = new StringBuilder();
        try {
            InputStream is = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int readByte = is.read(bytes);
            while (readByte != -1) {
                sb.append(new String(bytes, "gbk"));
                readByte = is.read(bytes);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void printWriter(String filename){
        String file = "K:\\my\\mygit\\CoreJava\\doc\\basie.out";
        try {
            BufferedReader br = new BufferedReader(new StringReader(this.fileRead(filename)));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            int lineCount = 1;
            String s;
            while ((s = br.readLine()) != null) {
                out.println(lineCount++ + ": " + s);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
