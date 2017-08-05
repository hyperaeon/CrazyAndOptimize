package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/4 0004.
 */
public final class Expect {

    public BoundException that(Object value) {
        return new BoundException(value);
    }
}
