package com.jdk8.other;

/**
 * Created by hzliyong on 2017/7/15 0015.
 */
public class DefaulableFactoryTest {

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl :: new);
        System.out.println(defaulable.notRequired());

        defaulable = DefaulableFactory.create(OverrideableImpl :: new);
        System.out.println(defaulable.notRequired());
    }
}
