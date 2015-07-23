package com.test.tree;

public class BinaryTree {

	private int data;
	private BinaryTree left;
	private BinaryTree right;

	public BinaryTree(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public void initTreeData(BinaryTree root, int data) {
		if (root.getData() >= data) {
			if (root.getLeft() == null) {
				root.setLeft(new BinaryTree(data));
			} else {
				initTreeData(root.getLeft(), data);
			}
		} else {
			if (root.getRight() == null) {
				root.setRight(new BinaryTree(data));
			} else {
				initTreeData(root.getRight(), data);
			}
		}
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	public String toString() {
		return Integer.valueOf(this.data).toString();
	}
}
