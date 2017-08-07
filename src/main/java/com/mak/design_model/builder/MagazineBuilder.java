package com.mak.design_model.builder;

/**
 * Created by makai on 2017/8/7.
 */
public class MagazineBuilder extends MediaBuilder {
    private Magazine m;

    @Override
    public void buildBase() {
        System.out.println("Building magazine framework");
        m = new Magazine();
    }

    @Override
    public void addMediaItem(MediaItem article) {
        System.out.println("Adding article" + article);
        m.add(article);
    }

    @Override
    public Media getFinishedMedia() {
        return m;
    }
}
