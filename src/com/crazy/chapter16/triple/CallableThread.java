package com.crazy.chapter16.triple;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " i : " + i);
        }
        return i;
    }

    public static void main(String[] args) {
        CallableThread callableThread = new CallableThread();
        FutureTask<Integer> futureTask = new FutureTask<>(callableThread);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " i: " + i);
            if (i == 20) {
                new Thread(futureTask, "return value").start();
            }
        }
        try {
            System.out.println("subThread: " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
