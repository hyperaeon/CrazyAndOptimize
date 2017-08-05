package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/3 0003.
 */
public abstract class LoanApplication {

    public void checkLoanApplication() throws ApplicationDenied {

    }

    protected abstract void checkIdentity() throws ApplicationDenied;

    protected abstract void checkIncomeHistory() throws ApplicationDenied;

    protected abstract void checkCreditHistory() throws ApplicationDenied;

}
