package com.effective.duplicate.chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hzliyong on 2017/7/15 0015.
 */
public class ArrayTest {

    private static final String[] PRIVATE_VALUES = {"abc", "def"};

    public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    public static void main(String[] args) {
        System.out.println(VALUES);
    }

    public static final String[] values() {
        return PRIVATE_VALUES.clone();
    }
}
