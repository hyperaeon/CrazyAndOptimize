package com.crazy.chapter16.triple;

public class Account {

    private String accountNo;

    private double balance;

    public Account() {}

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) {
        if (balance >= drawAmount) {
            System.out.println(Thread.currentThread().getName() + "取钱成功，吐出钞票：" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            balance -= drawAmount;
            System.out.println("余额为:" + balance);
        } else {
            System.out.println("余额不足");
        }
    }

}
