package com.jdk8.chapter8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hzliyong on 2017/8/4 0004.
 */
public class OpenClose {

    public static void main(String[] args) {

    }

    private static void ThreadLocalTest() {
        ThreadLocal<DateFormat> localFormatter = ThreadLocal.withInitial(() -> new SimpleDateFormat());
        DateFormat formatter = localFormatter.get();
    }

    private static void ThreadLocalTest2() {
        AtomicInteger threadId = new AtomicInteger();
        ThreadLocal<Integer> localId = ThreadLocal.withInitial(() -> threadId.getAndDecrement());
        int idForThisThread = localId.get();
    }
}
