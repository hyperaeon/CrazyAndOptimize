/**
 * 
 */
package com.effective.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ly
 *
 */
public class PhoneNumber {

	private final short areaCode;

	private final short prefix;

	private final short lineNumber;

	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 999, "areaCode");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "lineNumber");
		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber pn = (PhoneNumber) o;
		return pn.areaCode == areaCode && pn.lineNumber == lineNumber && pn.prefix == prefix;
	}

	/**
	 * @param areaCode2
	 * @param i
	 * @param string
	 */
	private void rangeCheck(int arg, int max, String name) {
		if (arg < 0 || arg > max) {
			throw new IllegalArgumentException(name + ":" + arg);
		}
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
	}

	@Override
	public String toString() {
		return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
	}
	
	public static void main(String[] args) {
		Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>();
		map.put(new PhoneNumber(707, 867, 5309), "jenny");
		System.out.println(map.get(new PhoneNumber(707, 867, 5309)));
	}

}
