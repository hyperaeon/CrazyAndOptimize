package com.jdk8.chapter4;

import java.util.function.BinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by hzliyong on 2017/7/20 0020.
 */
public class OverloadTest {

    public static void main(String[] args) {
        overloadedMethod((Predicate<Integer> )(x) -> true);
        overloaded((x, y) -> x + y);
    }

    private static void overloadedMethod (Predicate<Integer> predicate) {
        System.out.println("Predicate");
    }

    private static void overloadedMethod(IntPredicate predicate) {
        System.out.println("IntPredicate");
    }

    private static void overloaded(BinaryOperator<Integer> lambda) {
        System.out.println("BinaryOperator");
    }

    private static void overloaded(IntegerBiFunction lambda) {
        System.out.println("IntegerBinaryOpertor");
    }
}
