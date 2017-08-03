package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/2 0002.
 */
public class Nasa implements LandingObserver {
    @Override
    public void observerLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("We screw it!");
        }
    }
}
