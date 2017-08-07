package com.mak.design_model.builder;

/**
 * Created by makai on 2017/8/7.
 */
public class WebSiteBuilder extends MediaBuilder {
    private WebSite ws;
    @Override
    public void buildBase() {
        System.out.println("Building web site framework");
        ws = new WebSite();
    }

    @Override
    public void addMediaItem(MediaItem webItem) {
        System.out.println("Adding web item" + webItem);
        ws.add(webItem);
    }

    @Override
    public Media getFinishedMedia() {
        return ws;
    }
}
