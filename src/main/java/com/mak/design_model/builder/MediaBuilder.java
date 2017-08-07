package com.mak.design_model.builder;

/**
 * 抽象建造者角色，规范了所有媒体建造的步骤
 * Created by makai on 2017/8/7.
 */
public abstract class MediaBuilder {
    public void buildBase(){}
    public void addMediaItem(MediaItem item){}
    public Media getFinishedMedia(){return null;}
}
