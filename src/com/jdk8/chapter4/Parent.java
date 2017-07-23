package com.jdk8.chapter4;

/**
 * Created by hzliyong on 2017/7/20 0020.
 */
public interface Parent {

    public void message(String body);

    public default void welcome() {
        message("Prent: Hi!");
        System.out.println("parent welcome");
    }

    public String getLastMessage();
}
