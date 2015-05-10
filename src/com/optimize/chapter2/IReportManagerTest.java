package com.optimize.chapter2;

public class IReportManagerTest {

	public static void main(String[] args) {
		ReportManagerFactory rmf = new ReportManagerFactory();
		IReportManager rm = rmf.getFinancialReportManager("A");
		System.out.println(rm.createReport());
	}
}
