package com.mak.design_model.builder;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 测试程序
 * Created by makai on 2017/8/7.
 */
public class TestBuilder {
    private List input = Arrays.asList(new MediaItem[]{
            new MediaItem("item1"),new MediaItem("item2"),
            new MediaItem("item3"),new MediaItem("item4"),
    });

    @Test
    public void testBook(){
        MediaDirector director = new MediaDirector(new BookBuilder());
        Media book = director.produceMedia(input);
        String result = "book:"+book;
        System.out.println(result);
        Assert.assertEquals(book.size(),input.size());
    }

    @Test
    public void testMagazine(){
        MediaDirector director = new MediaDirector(new MagazineBuilder());
        Media magazine = director.produceMedia(input);
        String result = "magazine:"+magazine;
        System.out.println(result);
        Assert.assertEquals(magazine.size(),input.size());
    }

    @Test
    public void testWebSite(){
        MediaDirector director = new MediaDirector(new WebSiteBuilder());
        Media website = director.produceMedia(input);
        String result = "website:"+website;
        System.out.println(result);
        Assert.assertEquals(website.size(),input.size());
    }
}
