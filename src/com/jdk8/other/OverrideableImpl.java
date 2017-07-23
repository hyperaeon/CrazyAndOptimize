package com.jdk8.other;

/**
 * Created by hzliyong on 2017/7/15 0015.
 */
public class OverrideableImpl implements Defaulable {

    @Override
    public String notRequired() {
        return "overriding noteRequired";
    }
}
