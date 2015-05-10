package com.crazy.chapter6;

public enum Operation2 {

	PLUS{
		public double eval(double x,double y){
			return x + y;
		}
	},
	MINUS{
		public double eval(double x,double y){
			return x - y;
		}
	};
	public abstract double eval(double x,double y);
	public static void main(String[] args){
		System.out.println(Operation.PLUS.eval(3,4));;
	}
}
