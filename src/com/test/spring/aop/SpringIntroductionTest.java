package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIntroductionTest {

	public static void main(String[] args) {
		// 读取xml文件 AOP\src\META-INF
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"introduction.xml");

		GreetingImpl greeting = (GreetingImpl) context.getBean("springProxy");

		greeting.sayHello("greetingImpl单纯的sayhello");

		Apology apoloyProxy = (Apology) greeting; // 把打招呼类 强制向上强转

		apoloyProxy.saySorry("引入增强效果");
	}
}
