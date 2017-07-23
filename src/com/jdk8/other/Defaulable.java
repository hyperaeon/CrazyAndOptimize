package com.jdk8.other;

/**
 * Created by hzliyong on 2017/7/15 0015.
 */
public interface Defaulable {

    default String notRequired() {
        return "Default implementation";
    }
}
