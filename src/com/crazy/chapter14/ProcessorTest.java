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
					System.out.println("����" + method.getName() + "����ʧ�ܣ��쳣��" + 
							e.getCause());
				}
			}
		}
		System.out.println("ϵͳ�����гɹ�" + passed + "����ʧ��" + failed + "��");
	}
}
