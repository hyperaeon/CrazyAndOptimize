package com.jdk8.chapter3;

/**
 * Created by hzliyong on 2017/7/17 0017.
 */
public class Track {

    private String name;

    private int length;

    public Track() {

    }

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
