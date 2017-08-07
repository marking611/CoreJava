package com.mak.design_model.builder;

import java.util.List;

/**
 * 指导者角色，上下文
 * Created by makai on 2017/8/7.
 */
public class MediaDirector {
    private MediaBuilder mb;

    public MediaDirector(MediaBuilder mb) {
        this.mb = mb; //具有策略模式相似特征的
    }

    public Media produceMedia(List input){
        mb.buildBase();
        input.forEach(i->mb.addMediaItem((MediaItem) i));
        return mb.getFinishedMedia();
    }
}
