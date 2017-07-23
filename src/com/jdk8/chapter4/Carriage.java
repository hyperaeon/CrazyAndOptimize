package com.jdk8.chapter4;

/**
 * Created by hzliyong on 2017/7/22 0022.
 */
public interface Carriage {

    public default String rock() {
        return "... from side to side";
    }
}
