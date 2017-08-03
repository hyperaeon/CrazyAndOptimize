package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/2 0002.
 */
public class Aliens implements LandingObserver {

    @Override
    public void observerLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("They're distracted, let's invade earth!");
        }
    }
}
