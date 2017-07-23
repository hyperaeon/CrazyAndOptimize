package com.jdk8.chapter4;

/**
 * Created by hzliyong on 2017/7/22 0022.
 */
public interface Jukebox {
    public default String rock() {
        return "... all over the world!";
    }
}
