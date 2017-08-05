package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/4 0004.
 */
public abstract class MetricDataGraph {

    public abstract void updateUserTime(int value);

    public abstract void updateSystemTime(int value);

    public abstract void updateIoTime(int value);

}
