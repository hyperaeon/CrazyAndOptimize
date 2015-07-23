package com.test.tree;

import java.util.Stack;

public class TreeNodeTest {

	private static TreeNode root;
	private static Stack<String> stack = new Stack<String>();
	
	public static void initTree() {
		root = new TreeNode("root");
		TreeNode node1 = new TreeNode("1");
		TreeNode node2 = new TreeNode("2");
		root.setLeft(node1);
		root.setRight(node2);
		
		TreeNode node3 = new TreeNode("3");
		TreeNode node4 = new TreeNode("4");
		node1.setLeft(node3);
		node1.setRight(node4);
		
		TreeNode node5 = new TreeNode("5");
		node2.setLeft(node5);
		stack.clear();
	}
	
	public static void preInsertStack(TreeNode node) {
		if (node != null) {
			stack.push(node.getData());
			if (node.getLeft() != null) {
				preInsertStack(node.getLeft());
			} else if (node.getLeft() == null) {
				return;
			}
			if (node.getRight() != null) {
				preInsertStack(node.getRight());
			} else if (node.getRight() == null) {
				return;
			}
		}
	}
	
	public static void inInsertStack(TreeNode node) {
		if (node != null) {
			if (node.getLeft() != null) {
				inInsertStack(node.getLeft());
			} else if (node.getLeft() == null) {
				stack.push(node.getData());
				return;
			}
			stack.push(node.getData());
			if (node.getRight() != null) {
				inInsertStack(node.getRight());
			} else {
				return;
			}
		}
	}
	
	public static void afterInsertStack(TreeNode node) {
		if (node != null) {
			if (node.getLeft() != null) {
				afterInsertStack(node.getLeft());
			} else if (node.getLeft() == null) {
				stack.push(node.getData());
				return;
			}
			if (node.getRight() != null) {
				afterInsertStack(node.getRight());
			} else if (node.getRight() == null){
				stack.push(node.getData());
				return;
			}
			stack.push(node.getData());
		}
	}
	
	
	public static void main(String[] args) {
//		initTree();
//		preInsertStack(root);
//		for (String data : stack) {
//			System.out.println(data);
//		}
		
//		initTree();
//		inInsertStack(root);
//		for (String data : stack) {
//			System.out.println(data);
//		}
		
		initTree();
		afterInsertStack(root);
		for (String data : stack) {
			System.out.println(data);
		}
	}
}
