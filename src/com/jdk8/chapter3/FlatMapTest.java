package com.jdk8.chapter3;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Created by hzliyong on 2017/7/17 0017.
 */
public class FlatMapTest {

    public static void main(String[] args) {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        together.forEach(x -> System.out.println(x));
    }


}
