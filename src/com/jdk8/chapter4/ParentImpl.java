package com.jdk8.chapter4;

/**
 * Created by hzliyong on 2017/7/20 0020.
 */
public class ParentImpl implements Parent {


    @Override
    public void message(String body) {
        System.out.println(body + "Imp messege");
    }

    @Override
    public String getLastMessage() {
        return "imp getLastMessage";
    }

    public static void main(String[] args) {
        Parent parent = new ParentImpl();
        parent.welcome();
        System.out.println(parent.getLastMessage());
    }
}
