package com.leet.tree;

import java.util.ArrayList;
import java.util.Stack;

import com.leet.TreeNode;

/**
 * Binary Tree Level Order Traversal. Given a binary tree, return the level
 * order traversal of its nodes' values. (ie, from left to right, level by
 * level).
 * 
 * @author Allen
 * 
 */
public class LevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		process(root, result);
		return result;
	}

	private void process(TreeNode root, ArrayList<ArrayList<Integer>> result) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			ArrayList<TreeNode> children = new ArrayList<TreeNode>(stack.size());
			ArrayList<Integer> values = new ArrayList<Integer>();
			while (!stack.isEmpty()) {
				TreeNode n = stack.pop();
				children.add(n);
				values.add(n.val);
			}
			result.add(values);
			for (int i = children.size() - 1; i >= 0; i--) {
				TreeNode n = children.get(i);
				if (n.right != null) {
					stack.push(n.right);
				}
				if (n.left != null) {
					stack.push(n.left);
				}
			}
		}
	}
}