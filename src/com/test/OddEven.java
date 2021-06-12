package com.test;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: music-live-broadcast-entrance
 * @description:
 * @author: ly
 * @create: 2021-05-26 15:38
 **/
public class OddEven {

    private static volatile int value = 0;

    private static final Object obj = new Object();

    private static ReentrantLock reentrantLock = new ReentrantLock();

//    static class SolutionTask implements Runnable{
//        @Override
//        public void run() {
//            while (value <= 100){
//                synchronized (SolutionTask.class){
//                    System.out.println(Thread.currentThread().getName() + ":" + value++);
//                    SolutionTask.class.notify();
//                    try {
//                        SolutionTask.class.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            System.exit(1);
//        }
//    }

    static class SolutionTask implements Runnable{
        @Override
        public void run() {
            while (value <= 100){
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SolutionTask(), "偶数");
        Thread thread2 = new Thread(new SolutionTask(), "奇数");
        thread1.start();
        thread2.start();
    }

}
