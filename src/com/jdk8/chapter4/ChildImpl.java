package com.jdk8.chapter4;

/**
 * Created by hzliyong on 2017/7/20 0020.
 */
public class ChildImpl implements Child {

    @Override
    public void message(String body) {

    }

//    @Override
//    public void welcome() {
//        message("impl welcome");
//    }

    @Override
    public String getLastMessage() {
        return null;
    }

    public static void main(String[] args) {
        ChildImpl impl = new ChildImpl();
        impl.welcome();
        System.out.println(impl.getLastMessage());
    }
}
