package com.crazy.chapter7;

import java.util.ListResourceBundle;

public class MyMess_zh_CN extends ListResourceBundle {

	private final Object myData[][] = { { "msg", "{0},��ã������������{1}" } };

	@Override
	protected Object[][] getContents() {
		return myData;
	}

}
