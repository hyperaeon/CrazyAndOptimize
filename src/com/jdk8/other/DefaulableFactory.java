package com.jdk8.other;

import java.util.function.Supplier;

/**
 * Created by hzliyong on 2017/7/15 0015.
 */
public interface DefaulableFactory {

    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }
}
