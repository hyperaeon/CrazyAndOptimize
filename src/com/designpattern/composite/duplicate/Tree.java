package com.designpattern.composite.duplicate;

public class Tree {

	TreeNode root = null;
	
	public Tree(String name) {
		root = new TreeNode(name);
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree("A");
		
		TreeNode node1 = new TreeNode("B");
		TreeNode node2 = new TreeNode("C");
		node1.add(node2);
		tree.root.add(node1);
		System.out.println("Build success");
	}
	
}
