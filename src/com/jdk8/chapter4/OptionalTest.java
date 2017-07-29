package com.jdk8.chapter4;

import java.util.Optional;

/**
 * Created by hzliyong on 2017/7/23 0023.
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> a=  Optional.of("a");
        System.out.println(a.get());
        Optional emptyOptional = Optional.empty();
        String n = null;
        Optional alsoEmpty = Optional.ofNullable(n);
        System.out.println(emptyOptional.isPresent());
        System.out.println(alsoEmpty.isPresent());
        System.out.println(a.isPresent());
        System.out.println(emptyOptional.orElse("b"));
        System.out.println(emptyOptional.orElseGet(() -> "c"));
    }
}
