package com.jdk8.chapter8;

/**
 * Created by hzliyong on 2017/8/3 0003.
 */
public class CompanyLoanApplication extends LoanApplication2 {


    public CompanyLoanApplication(Company company) {
        super(company::checkIdentity,
                company::checkHistoricalDebt,
                company::checkProfitAndLoss);
    }
}
