package com.effective.chapter6;

public enum PayrollDay {

	MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY),
	THIRSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY),SATURDAY(PayType.WEEKEND),
	SUNDAY(PayType.WEEKEND);
	
	private final PayType payType;
	
	private PayrollDay(PayType payType) {
		this.payType = payType;
	}
	
	double pay(double hoursWorked, double payRate) {
		return payType.pay(hoursWorked, payRate);
	}
	
	private enum PayType {
		
		WEEKDAY { 
			double overtimePay(double hours, double payRate) {
				return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * payRate / 2;
			}
		},
		WEEKEND {
			double overtimePay(double hours, double payRate) {
				return hours * payRate / 2;
			}
		};
		
		abstract double overtimePay(double hours, double payRate);
		
		double pay(double hoursWorked, double payRate) {
			double basePay = hoursWorked * payRate;
			return basePay + overtimePay(hoursWorked, payRate);
		}
		
		private static final int HOURS_PER_SHIFT = 8;
		
	}
}
