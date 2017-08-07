package com.mak.design_model.builder;

/**
 * 具体建造者角色
 * Created by makai on 2017/8/7.
 */
public class BookBuilder extends MediaBuilder {
    private Book b;

    @Override
    public void buildBase() {
        System.out.println("Building book framework");
        b = new Book();
    }

    @Override
    public void addMediaItem(MediaItem chapter) {
        System.out.println("Adding chapter" + chapter);
        b.add(chapter);
    }

    @Override
    public Media getFinishedMedia() {
        return b;
    }
}
