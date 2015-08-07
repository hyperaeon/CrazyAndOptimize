package com.optimize.chapter2.duplicate;

public class DBQueryProxy implements IDBQuery {

	private DBQuery real = null;
	
	@Override
	public String request() {
		if (real == null) {
			real = new DBQuery();
		}
		return real.request();
	}

}
