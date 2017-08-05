package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/3 0003.
 */
public abstract class Company {

    public abstract void checkIdentity() throws ApplicationDenied;

    public abstract void checkProfitAndLoss() throws ApplicationDenied;

    public abstract void checkHistoricalDebt() throws ApplicationDenied;
}
