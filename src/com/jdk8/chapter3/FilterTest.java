package com.jdk8.chapter3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hzliyong on 2017/7/17 0017.
 */
public class FilterTest {

    public static void main(String[] args ){
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(Collectors.toList());
        beginningWithNumbers.forEach(x -> System.out.println("x: " + x));
    }

    private static boolean isDigit(char c) {
        if (c > 47 && c < 58) {
            return true;
        }
        return false;
    }


}
