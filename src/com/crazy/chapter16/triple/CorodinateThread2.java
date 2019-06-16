package com.crazy.chapter16.triple;

public class CorodinateThread2 implements Runnable {

    private int i;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i <= 100) {
                    System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " " + i);
                    i++;
                    try {
                        wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.exit(1);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                CorodinateThread2 corodinateThread = new CorodinateThread2();
                new Thread(corodinateThread, "first").start();
                new Thread(corodinateThread, "second").start();
            }
        }
    }
}
