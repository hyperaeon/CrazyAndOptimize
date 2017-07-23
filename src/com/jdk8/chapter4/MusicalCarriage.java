package com.jdk8.chapter4;

/**
 * Created by hzliyong on 2017/7/22 0022.
 */
public class MusicalCarriage implements Carriage,Jukebox{

    @Override
    public String rock() {
        return Carriage.super.rock();
    }

    public static void main(String[] args) {
        MusicalCarriage carriage = new MusicalCarriage();
        carriage.rock();
    }
}
