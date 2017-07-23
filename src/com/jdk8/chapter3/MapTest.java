package com.jdk8.chapter3;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hzliyong on 2017/7/16 0016.
 */
public class MapTest {

    public static void main(String[] args) {
        List<String> collected = Stream.of("a", "b", "hlelo")
                .map(str -> str.toUpperCase())
                .collect(Collectors.toList());
        collected.forEach(x -> System.out.println(x));
    }
}
