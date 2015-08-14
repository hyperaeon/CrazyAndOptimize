package com.optimize.chapter2.trip.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {

	Map<String, IReportManager> financialReportManager = new HashMap<String, IReportManager>();

	Map<String, IReportManager> employeeReportManager = new HashMap<String, IReportManager>();

	IReportManager getFinancialReportManager(String tenantId) {
		IReportManager r = financialReportManager.get(tenantId);
		if (r == null) {
			r = new FinancialReportManager(tenantId);
			financialReportManager.put(tenantId, r);
		}
		return r;
	}

	IReportManager getEmployeeReportManager(String tenantId) {
		IReportManager r = employeeReportManager.get(tenantId);
		if (r == null) {
			r = new EmployeeReportManager(tenantId);
			employeeReportManager.put(tenantId, r);
		}
		return r;
	}
}
