package com.test;

import java.util.Stack;

public class TreeIteration {

	private static TreeNode root;
	static {
		// root = new TreeNode("1");
		// TreeNode two = new TreeNode("2");
		// TreeNode three = new TreeNode("3");
		// root.setLeftChildren(two);
		// root.setRightChildren(three);
		//
		// TreeNode four = new TreeNode("4");
		// TreeNode five = new TreeNode("5");
		// two.setLeftChildren(four);
		// two.setRightChildren(five);
		//
		// TreeNode six = new TreeNode("6");
		// three.setLeftChildren(six);
	}

	/**
	 * @param node
	 * @param stack
	 * @return
	 */
	// private static TreeNode addNode(TreeNode node, Stack<TreeNode> stack) {
	// if (node.isLeftChildrenExist()) {
	// addNode(node.getLeftChildren(), stack);
	// }
	// if (node.isRightChildrenExist()) {
	// addNode(node.getRightChildren(), stack);
	// }
	//
	//
	// }
	public static void main(String[] args) {
		root = new TreeNode("1");
		TreeNode two = new TreeNode("2");
		TreeNode three = new TreeNode("3");
		root.setLeftChildren(two);
		root.setRightChildren(three);

		TreeNode four = new TreeNode("4");
		TreeNode five = new TreeNode("5");
		two.setLeftChildren(four);
		two.setRightChildren(five);

		TreeNode six = new TreeNode("6");
		three.setLeftChildren(six);
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		stack.push(two);
		stack.push(four);
		stack.push(five);
		stack.push(three);
		stack.push(six);
		for (TreeNode node : stack) {
			System.out.println(node);
		}

	}
}
