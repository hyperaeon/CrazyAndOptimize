package com.crazy.chapter16.triple;

public class DeadLock implements Runnable {

    private A a;
    private B b;

    public DeadLock() {}

    public DeadLock(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public void init() {
        Thread.currentThread().setName("主线程");
        b.bar(a);
        System.out.println("进入主线程后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        a.foo(b);
        System.out.println("进入副线程后");
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        DeadLock deadLock = new DeadLock(a, b);
        Thread thread = new Thread(deadLock, "主线程");
        thread.start();
        deadLock.init();
    }
}

class A {

    public synchronized void foo(B b) {
        System.out.println(Thread.currentThread().getName() + "进入A的foo");
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "企图调用B的last");
        b.last();
    }

    public synchronized void last() {
        System.out.println(Thread.currentThread().getName() + "进入A的last方法");
    }
}

class B {

    public synchronized void bar(A a) {
        System.out.println(Thread.currentThread().getName() + "进入B的bar");
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "企图调用a的last");
        a.last();
    }

    public synchronized void last() {
        System.out.println(Thread.currentThread().getName() + "进入B的last方法");
    }
}
