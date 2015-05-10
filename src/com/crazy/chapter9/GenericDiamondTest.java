package com.crazy.chapter9;

import java.util.Collection;
import java.util.List;

class MyClass<E>{
	public <T> MyClass(T t){
		System.out.println(t);
	}
}
public class GenericDiamondTest {

	public static void main(String[] args){
		MyClass<String> mc1 = new MyClass<>(3);
		MyClass<String> mc2 = new <Integer> MyClass<String>(4);
		MyClass<String> mc3 = new <Integer> MyClass<String>(5);
//		List<String>[] lsa = new List<String>[10]; 
	}
	
	public static <T> T copy(Collection<T> dest,Collection<? extends T> src){
		T last = null;
		for(T ele : src){
			last = ele;
			dest.add(ele);
		}
		return last;
	}
	
	public static <T> T copys(Collection<? super T> dest,Collection<T> src){
		T last = null;
		for(T ele : src){
			last = ele;
			dest.add(ele);
		}
		return last;
	}
}
