package com.crazy.chapter10;

public class MultiExceptionTest {
	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("�����������������Ľ���ǣ�" + c);
		} catch (IndexOutOfBoundsException | NumberFormatException
				| ArithmeticException e) {
			System.out.println("����Խ�硢��ʽ�쳣�������쳣");
		} catch (Exception e) {
			System.out.println("δ֪�쳣");
		}
	}
}
