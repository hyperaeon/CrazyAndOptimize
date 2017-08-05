package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/3 0003.
 */
public class LoanApplication2 {

    private final Criteria identity;

    private final Criteria creditHistory;

    private final Criteria incomeHistory;

    public LoanApplication2(Criteria identity,
                            Criteria creditHistory,
                            Criteria incomeHistory) {
        this.identity = identity;
        this.creditHistory = creditHistory;
        this.incomeHistory = incomeHistory;
    }

    public void checkLoanApplication() throws ApplicationDenied {
        identity.check();
        creditHistory.check();
        incomeHistory.check();
        reportFindings();
    }

    private void reportFindings() {

    }
}
