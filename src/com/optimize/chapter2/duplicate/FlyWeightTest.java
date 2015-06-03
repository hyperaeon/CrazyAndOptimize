package com.optimize.chapter2.duplicate;

public class FlyWeightTest {

	public static void main(String[] args) {
		ReportManagerFactory factory = new ReportManagerFactory();
		IReportManager rm = factory.getFinancialReportManager("A");
		System.out.println(rm + " " + rm.createReport());
		IReportManager rm2 = factory.getFinancialReportManager("A");
		System.out.println(rm2 + " " + rm2.createReport());
		
	}
}
