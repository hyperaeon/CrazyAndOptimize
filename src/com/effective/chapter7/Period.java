package com.effective.chapter7;

import java.util.Date;

public class Period {

	private final Date start;

	private final Date end;

	public Period(Date start, Date end) {
		// this.start = start;
		// this.end = end;
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (start.compareTo(end) > 0) {
			throw new IllegalArgumentException(start + " after " + end);
		}
	}

	public Date getStart() {
		return new Date(start.getTime());
	}

	public Date getEnd() {
		return new Date(end.getTime());
	}

}
