package com.effective.chapter11;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class PeriodProxy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date start;
	private Date end;

	public PeriodProxy(Date start, Date end) {
		this.start = start;
		this.end = end;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	private Object writeReplace() {
		return new SerializableProxy(this);
	}

	private void readObject(ObjectInputStream stream)
			throws InvalidObjectException {
		throw new InvalidObjectException("Proxy required");
	}

	private static class SerializableProxy implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Date start;
		private Date end;

		public SerializableProxy(PeriodProxy proxy) {
			this.start = proxy.start;
			this.end = proxy.end;
		}

		public Date getStart() {
			return start;
		}

		public void setStart(Date start) {
			this.start = start;
		}

		public Date getEnd() {
			return end;
		}

		public void setEnd(Date end) {
			this.end = end;
		}

		private Object readResolve() {
			return new PeriodProxy(start, end);
		}

	}
}
