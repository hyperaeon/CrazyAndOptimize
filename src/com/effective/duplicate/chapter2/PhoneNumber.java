package com.effective.duplicate.chapter2;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {

	private final short areaCode;
	
	private final short prefix;
	
	private final short lineNumber;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 9999, "area code");
		rangeCheck(prefix, 9999, "prefix");
		rangeCheck(lineNumber, 9999, "lineNumber");
		this.areaCode = (short)areaCode;
		this.prefix = (short)prefix;
		this.lineNumber = (short)lineNumber;
				
	}
	
	public static void rangeCheck(int arg, int max, String name) {
		if (arg < 0 || arg > max) {
			throw new IllegalArgumentException(name + ": " + arg);
		}
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + areaCode;
		result = prime * result + lineNumber;
		result = prime * result + prefix;
		return result;
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber pn = (PhoneNumber)o;
		return pn.areaCode == areaCode
				&& pn.lineNumber == lineNumber
				&& pn.prefix == prefix;
	}

	public static void main(String[] args) {
		Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>();
		map.put(new PhoneNumber(708, 867, 5309), "Jenny");
		System.out.println(map.get(new PhoneNumber(408, 867, 5309)));
		
	}
}
