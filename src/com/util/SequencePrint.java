package com.util;

import java.util.concurrent.Semaphore;

/**
 * @program: CrazyAndOptimize
 * @description:
 * @author: ly
 * @create: 2021-05-31 15:01
 **/
public class SequencePrint {

    private static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        method1();
    }

    private static void method1() throws InterruptedException {
        int N = 3;
        Thread[] threads = new Thread[N];
        final Semaphore[] semaphores = new Semaphore[N];
        for (int i = 0; i < N; i++) {
            semaphores[i] = new Semaphore(1);
            if (i != N-1) {
                //前两个先acquire
                semaphores[i].acquire();
            }
            System.out.println(semaphores[i]);
        }

        for (int i = 0; i < N; i++) {
            final Semaphore currentSemaphore = semaphores[i];
            final Semaphore lastSemaphore = i == 0 ? semaphores[N - 1] : semaphores[i - 1];
            System.out.println("currentSemaphore: " + currentSemaphore);
            System.out.println("lastSemaphore: " + lastSemaphore);
            threads[i] = new Thread(() -> {
                try {
                    while (true) {
                        lastSemaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + ",thread index " + result++);
                        if (result > 100) {
                            System.exit(0);
                        }
                        currentSemaphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
    }
}
