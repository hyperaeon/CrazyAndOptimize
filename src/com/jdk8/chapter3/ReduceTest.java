package com.jdk8.chapter3;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Created by hzliyong on 2017/7/17 0017.
 */
public class ReduceTest {

    public static void main(String[] args) {
        int count = Stream.of(1, 3, 2)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(count);
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        count = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1)
                , 2)
        ,3);
    }
}
