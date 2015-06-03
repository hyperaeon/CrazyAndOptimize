package com.crazy.chapter10;

public class DivTest {

	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("您输入的两个数相除的结果是：" + c);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("数组越界");
		} catch (NumberFormatException e) {
			System.out.println("格式异常");
		} catch (ArithmeticException e) {
			System.out.println("算术异常");
		} catch (Exception e) {
			System.out.println("未知异常");
		}
	}
}
