package com.optimize.chapter2;

public class ProxyComparison {

	public static final int CIRCLE = 30000000;

	public static void main(String[] args) throws Exception {
		IDBQuery d = null;
		long begin = System.currentTimeMillis();
		d = JdkDbQueryProxy.createJdkProxy();
		System.out.println("createJdkProxy:"
				+ (System.currentTimeMillis() - begin));
		System.out.println("JdkProxy class:" + d.getClass().getName());
		begin = System.currentTimeMillis();
		for (int i = 0; i < CIRCLE; i++) {
			d.request();
		}
		System.out.println("callJdkProxy:"
				+ (System.currentTimeMillis() - begin));
		System.out.println("CglibProxy class:" + d.getClass().getName());
	}
}
