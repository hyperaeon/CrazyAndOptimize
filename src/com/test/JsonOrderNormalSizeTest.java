package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonOrderNormalSizeTest {

	public static void main(String[] args) {
		List<JsonOrderNormalSize> list = new ArrayList<JsonOrderNormalSize>();
		JsonOrderNormalSize size1 = new JsonOrderNormalSize();
		CurrencyPairGroup group1 = new CurrencyPairGroup();
		group1.setPricingServiceId("paaa");
		group1.setCcy1("ccy1aaa");
		group1.setCcy2("ccy2aaa");
		size1.setCurrencyPairGroup(group1);
		size1.setIm("null");
		size1.setFund("fundaaa");
		size1.setCustId("custidaaa");
		list.add(size1);
		
		JsonOrderNormalSize size3 = new JsonOrderNormalSize();
		CurrencyPairGroup group3 = new CurrencyPairGroup();
		group3.setPricingServiceId("pccc");
		group3.setCcy1("ccy1ccc");
		group3.setCcy2("ccy2ccc");
		size3.setCurrencyPairGroup(group3);
		size3.setIm("null");
		size3.setFund("fundccc");
		size3.setCustId("custidccc");
		list.add(size3);
		
		JsonOrderNormalSize size2 = new JsonOrderNormalSize();
		CurrencyPairGroup group2 = new CurrencyPairGroup();
		group2.setPricingServiceId("pbbb");
		group2.setCcy1("ccy1bbb");
		group2.setCcy2("ccy2bbb");
		size2.setCurrencyPairGroup(group2);
		size2.setIm("null");
		size2.setFund("fundbbb");
		size2.setCustId("custidbbb");
		list.add(size2);
		Collections.sort(list);
		for (JsonOrderNormalSize size : list) {
			System.out.println(size);
		}
		
	}
}
