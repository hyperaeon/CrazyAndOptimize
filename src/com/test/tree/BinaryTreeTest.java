package com.test.tree;

public class BinaryTreeTest {

	public static void preOrder(BinaryTree node) {
		if (node != null) {
			System.out.println(node.getData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 5, 10, 12, 9, 8 };
		BinaryTree tree = new BinaryTree(a[0]);
		for (int i = 1; i < a.length; i++) {
			tree.initTreeData(tree, a[i]);
		}
		preOrder(tree);
	}
}
