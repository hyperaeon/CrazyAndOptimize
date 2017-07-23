package com.jdk8.chapter4;

/**
 * Created by hzliyong on 2017/7/20 0020.
 */
public interface Child extends Parent {

    @Override
    public default void welcome() {
        message("Child: hi");
        System.out.println("Child welcome");
    }
}
