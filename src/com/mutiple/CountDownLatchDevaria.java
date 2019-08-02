package com.mutiple;

import java.util.concurrent.CountDownLatch;

/**
 * @author hzliyong
 * @description
 * @date 2019/8/2 0002
 * @time 16:02
 */
public class CountDownLatchDevaria {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    static class TeacherThread extends Thread {
        @Override
        public void run() {
            System.out.println("Waiting for the students, total number: " + countDownLatch.getCount());
            try {
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Class begin ...");
        }
    }

    static class StudentThread extends Thread {
        @Override
        public void run() {
            System.out.println("Arrived in class ...");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        new TeacherThread().start();
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            new StudentThread().start();
        }
    }
}
