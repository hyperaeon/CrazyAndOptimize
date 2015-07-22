package com.test.binarytree;

public class BinaryTreeOrderTest {

	public static void main(String[] args) {
		int arr[] = {12, 76, 35, 22, 16, 48, 90, 46, 9, 40};
		BinaryTree root = new BinaryTree(arr[0]);
		for (int i = 1; i < arr.length; i ++) {
			root.insertData(root, arr[i]);
		}
		System.out.println("�ȸ�����");
		BinaryTreeOrder.preOrder(root);
		System.out.println();
		System.out.println("�и�����");
		BinaryTreeOrder.inOrder(root);
		System.out.println();
		System.out.println("�������");
		BinaryTreeOrder.afterOrder(root);
	}
}
