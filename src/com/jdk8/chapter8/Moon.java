package com.jdk8.chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzliyong on 2017/8/2 0002.
 */
public class Moon {

    private final List<LandingObserver> observers = new ArrayList<>();


    public void land(String name) {
        for (LandingObserver observer : observers) {
            observer.observerLanding(name);
        }
    }

    public void startSpying(LandingObserver observer) {
        observers.add(observer);
    }

    public static void main(String[] args) {

    }

    private static void lambda() {
        Moon moon = new Moon();
        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("We screw it");
            }
        });

        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("They're distracted, let's invade earth!");
            }
        });
        moon.land("An asteroid");
        moon.land("Apollo 11");
    }

    private static void nonLambda() {
        Moon moon = new Moon();
        moon.startSpying(new Nasa());
        moon.startSpying(new Aliens());
        moon.land("An asteroid");
        moon.land("Apollo 11");
    }
}
