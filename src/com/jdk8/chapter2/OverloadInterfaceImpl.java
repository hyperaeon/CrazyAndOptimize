package com.jdk8.chapter2;

import java.util.function.Predicate;

/**
 * Created by hzliyong on 2017/7/16 0016.
 */
public class OverloadInterfaceImpl implements OverloadInterface {

    public static void main(String[] args) {
        OverloadInterfaceImpl impl = new OverloadInterfaceImpl();
//        boolean t = impl.check(x -> x > 5);
    }

    @Override
    public boolean check(Predicate<Integer> predicate) {
        return false;
    }

    @Override
    public boolean check(IntPred predicate) {
        return true;
    }
}
