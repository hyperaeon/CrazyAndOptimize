package com.jdk8.chapter2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created by hzliyong on 2017/7/16 0016.
 */
public class FirstLambda {

    private String userName;

    public static void main(String[] args) {
        predicateTest();
        binrayOperatorTest();
    }

    private static void binrayOperatorTest() {
        BinaryOperator<Long> addLong = (x, y) -> x + y;
        System.out.println(addLong);
    }

    private static void predicateTest() {
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(2));
    }

    private void finalTest() {
        Button button = new Button();
        button.addActionListener(event -> System.out.println("button clicked"));
        final String[] array = {"Hello", "Scala"};
        String name = getUserName();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hi" + name);
            }
        });
        button.addActionListener(event -> System.out.println("hi" + name));
    }

    /**
     * 不同类型的lambda
     */
    private static void differentLambda() {
        Runnable onArguments = () -> System.out.println("Hello lambda");
        ActionListener oneArguments = event -> System.out.println("button clicked");
        Runnable multiStatement = () -> {
            System.out.println("Hello");
            System.out.println(" World");
        };
        BinaryOperator<Long> add = (x, y) -> x + y;
        BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
    }

    public String getUserName() {
        return userName;
    }
}
