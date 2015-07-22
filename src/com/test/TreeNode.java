package com.test;

public class TreeNode {

	private String name;

	private TreeNode leftChildren;

	private TreeNode rightChildren;

	public TreeNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getLeftChildren() {
		return leftChildren;
	}

	public void setLeftChildren(TreeNode leftChildren) {
		this.leftChildren = leftChildren;
	}

	public TreeNode getRightChildren() {
		return rightChildren;
	}

	public void setRightChildren(TreeNode rightChildren) {
		this.rightChildren = rightChildren;
	}

	public String toString() {
		return name;
	}

	public boolean isLeftChildrenExist() {
		return leftChildren != null;
	}

	public boolean isRightChildrenExist() {
		return rightChildren != null;
	}
	
	
}
