package com.test.spring.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor
		implements Apology {

	public void saySorry(String name) {
		System.out.println(name + " I am sorry!");
	}

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		return super.invoke(arg0);
	}
	
}
