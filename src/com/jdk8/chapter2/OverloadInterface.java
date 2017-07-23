package com.jdk8.chapter2;

import java.util.function.Predicate;

/**
 * Created by hzliyong on 2017/7/16 0016.
 */
public interface OverloadInterface {

    boolean check(Predicate<Integer> predicate);

    boolean check(IntPred predicate);
}
