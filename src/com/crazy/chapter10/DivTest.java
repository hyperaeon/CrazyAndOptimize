package com.crazy.chapter10;

public class DivTest {

	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("�����������������Ľ���ǣ�" + c);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("����Խ��");
		} catch (NumberFormatException e) {
			System.out.println("��ʽ�쳣");
		} catch (ArithmeticException e) {
			System.out.println("�����쳣");
		} catch (Exception e) {
			System.out.println("δ֪�쳣");
		}
	}
}
