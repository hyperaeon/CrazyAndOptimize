package com.test.binarytree;

public class BinaryTree {

	int data;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void insertData(BinaryTree root, int data) {
		if (root.data < data) {
			if (root.right == null) {
				root.right = new BinaryTree(data);
			} else {
				insertData(root.right, data);
			}
		} else if (root.data > data) {
			if (root.left == null) {
				root.left = new BinaryTree(data);
			} else {
				insertData(root.left, data);
			}
		}
	}
}
