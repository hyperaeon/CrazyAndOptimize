package com.crazy.chapter4;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArraysTest {

	public static void main(String[] args) {
		test1();
		binarySearchTest();
		parallelTest();
	}
	
	private static void parallelTest() {
		int[] arr1 = new int[] {3, -4, 25, 16, 30, 18};
		Arrays.parallelSort(arr1);
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = new int[] {3, -4, 25, 16, 30, 18};
//		Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
//			@Override
//			public int applyAsInt(int left, int right) {
//				return left * right;
//			}
//		});
		Arrays.parallelPrefix(arr2, (left, right) -> left * right);
		System.out.println(Arrays.toString(arr2));
		int[] arr3 = new int[5];
		
		Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
			public int applyAsInt(int operand) {
				return operand * 5;
			}
		});
		System.out.println(Arrays.toString(arr3));
	}
	
	private static void binarySearchTest() {
		int[] a = new int[]{3, 5, 1, 2};
		int index = Arrays.binarySearch(a, 1);
		System.out.println(index);
	}
	
	private static void test1() {
		int[] a = new int[]{3, 4, 5, 6};
		int[] b = new int[]{3, 4, 5, 6};
		System.out.println("a数组和b数组是否相等：" + Arrays.equals(a, b));
		int[] c = Arrays.copyOf(a, 6);
		System.out.println("c数组的元素为：" + Arrays.toString(c));
		Arrays.fill(c, 2, 4, 1);
		System.out.println("c数组的元素为：" + Arrays.toString(c));
		Arrays.sort(c);
		System.out.println("c数组的元素为：" + Arrays.toString(c));
	}
}
