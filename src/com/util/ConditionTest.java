package com.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: CrazyAndOptimize
 * @description:
 * @author: ly
 * @create: 2021-05-27 17:38
 **/
public class ConditionTest {

    private static int num = 1;

    private static ReentrantLock lock = new ReentrantLock();

    private static final Condition conditionA = lock.newCondition();

    private static final Condition conditionB = lock.newCondition();

    private static final Condition conditionC = lock.newCondition();

    private static final CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
//        method1();
        method2();
    }

    public static void method2() throws InterruptedException {
        long loop = countDownLatch.getCount();
        new Thread(new LoopThread(loop), "A").start();
        new Thread(new LoopThread(loop), "B").start();
        new Thread(new LoopThread(loop), "C").start();
        countDownLatch.await();
        System.out.println("打印完毕...");
    }

    static class LoopThread implements Runnable {

        private long loop;

        public LoopThread() {}

        public LoopThread(long loop){
            this.loop = loop;
        }

        @Override
        public void run() {
            for (int i = 1; i <= loop; i++) {
                try {
                    if (Thread.currentThread().getName().equals("A")) {
                        printA();
                    } else if (Thread.currentThread().getName().equals("B")) {
                        printB();
                    } else {
                        printC(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void method1() throws InterruptedException {
        long loop = countDownLatch.getCount();
        new Thread(() -> {
            for (int i = 1; i <= loop; i++) {
                try {
                    printA();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= loop; i++) {
                try {
                    printB();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= loop; i++) {
                try {
                    printC(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        countDownLatch.await();
        System.out.println("打印完毕.........");
    }

    private static void printA() throws InterruptedException{
        lock.lock();
        if (num != 1) {
            conditionA.await();
        }
        System.out.println(Thread.currentThread().getName());
        num = 2;
        conditionB.signal();
        lock.unlock();
    }

    private static void printB() throws InterruptedException{
        lock.lock();
        if (num != 2) {
            conditionB.await();
        }
        System.out.println(Thread.currentThread().getName());
        num = 3;
        conditionC.signal();
        lock.unlock();
    }

    private static void printC(int loop) throws InterruptedException{
        lock.lock();
        if (num != 3) {
            conditionC.await();
        }
        System.out.println(Thread.currentThread().getName() + " " + loop);
        num = 1;
        conditionA.signal();
        countDownLatch.countDown();
        lock.unlock();
    }
}
