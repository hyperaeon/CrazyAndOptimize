package com.effective.chapter11;

import java.io.Serializable;

public class StringList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int size = 0;
	private Entry head = null;

	private static class Entry implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String data;
		Entry next;
		Entry previous;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Entry getNext() {
			return next;
		}

		public void setNext(Entry next) {
			this.next = next;
		}

		public Entry getPrevious() {
			return previous;
		}

		public void setPrevious(Entry previous) {
			this.previous = previous;
		}

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Entry getHead() {
		return head;
	}

	public void setHead(Entry head) {
		this.head = head;
	}

}
