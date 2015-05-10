package com.crazy.chapter14;

import java.lang.reflect.Method;

public class ProcessorTest {

	public static void process(String name)throws ClassNotFoundException{
		int passed = 0;
		int failed = 0;
		for(Method method : Class.forName(name).getMethods()){
			if(method.isAnnotationPresent(TestNG.class)){
				try{
					method.invoke(null);
					passed ++;
				}catch(Exception e){
					failed ++;
					System.out.println("方法" + method.getName() + "运行失败，异常：" + 
							e.getCause());
				}
			}
		}
		System.out.println("系统共运行成功" + passed + "个，失败" + failed + "个");
	}
}
