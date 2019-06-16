package com.crazy.chapter16.triple;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockAccount {

    private final ReentrantLock lock = new ReentrantLock();

    private String accountNo;

    private double balance;

    public ReentrantLockAccount() {}

    public ReentrantLockAccount(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void draw(double drawAccount) {
        lock.lock();
        try {
            if (balance >= drawAccount) {
                System.out.println(Thread.currentThread().getName() + "取钱成功，取出：" + drawAccount);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance -= drawAccount;
                System.out.println(Thread.currentThread().getName() + "余额：" + balance);
            } else {
                System.out.println("余额不足");
            }
        } finally {
            lock.unlock();
        }
    }
}
