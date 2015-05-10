package com.crazy.chapter18;

public class ProxyTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args)throws Exception {
		Person person = new Man();
		Person man = (Person)MyProxyFactory.getProxy(person);
		man.info();
		man.run();
		
		person = new Woman();
		Person woman = (Person)MyProxyFactory.getProxy(person);
		woman.info();
		woman.run();
	}

}
