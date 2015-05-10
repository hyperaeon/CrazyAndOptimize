package com.crazy.chapter9;
class Foo
{
	public <T> Foo(T t){
		System.out.println(t);
	}
}
public class GenericConstructor {

	public static void main(String[] args){
		new Foo("·è¿ñjava");
		new Foo(200);
		new <String> Foo("·è¿ñjava");
		new <Double> Foo(2.3);
	}
}
