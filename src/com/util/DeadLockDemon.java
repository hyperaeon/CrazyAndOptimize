package com.util;

/**
 * @program: music-live-broadcast-entrance
 * @description:
 * @author: ly
 * @create: 2021-05-26 17:26
 **/
public class DeadLockDemon {

    private static final Object resource1 = new Object();

    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " 执行1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " 执行2");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " 执行1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " 执行2");
                }
            }
        }).start();
    }
}
