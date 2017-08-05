package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/4 0004.
 */
public class Runner {

    private static Runner runner;

    private Runner() {

    }

    public static Runner getInstance() {
        if (runner == null) {
            runner = new Runner();
        }
        return runner;
    }

    public static Runner current() {
        return getInstance();
    }

    public void recordSuccess(Suite suite, String description) {

    }

    public void recordFailue(Suite suite, String description, AssertionError cause) {

    }

    public void recordError(Suite suite, String description, Throwable causes) {

    }
}
