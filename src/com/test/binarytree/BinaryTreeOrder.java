package com.test.binarytree;

public class BinaryTreeOrder {

	public static void preOrder(BinaryTree root) {
		if (root != null) {
			System.out.print(root.data + "--");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void inOrder(BinaryTree root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + "--");
			inOrder(root.right);
		}
	}
	
	public static void afterOrder(BinaryTree root) {
		if (root != null) {
			afterOrder(root.left);
			afterOrder(root.right);
			System.out.print(root.data + "--");
		}
	}
}
