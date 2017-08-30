package com.mak;

import com.mak.io.InputStreamTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by makai on 2017/8/29.
 */
public class IOTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOTest.class);
    private static InputStreamTest inputStreamTest;
    private long begin;
    private long end;
    private String filename = "K:\\my\\mygit\\CoreJava\\doc\\is_read.txt";

    @Before
    public void init() {
        inputStreamTest = new InputStreamTest();
        begin = System.currentTimeMillis();
    }

    @Test
    public void bufferRead(){
        inputStreamTest.bufferRead(filename);
    }

    @Test
    public void stringRead(){
        inputStreamTest.stringRead(filename);
    }

    @Test
    public void fileRead() {
        inputStreamTest.fileRead(filename);
    }

    @Test
    public void printWriter(){
        inputStreamTest.printWriter(filename);
    }

    @After
    public void after(){
        end = System.currentTimeMillis();
        LOGGER.info("方法用时："+(end-begin));
    }
}
