package com.leet.tree;

import java.util.ArrayList;
import java.util.Stack;

import com.leet.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, return its zigzag level
 * order traversal as: [ [3], [20,9], [15,7] ]
 * 
 * @author Allen
 * 
 */
public class ZigzagLevelOrder {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
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
		boolean reverse = false;
		while (!stack.isEmpty()) {
			ArrayList<TreeNode> children = new ArrayList<TreeNode>(stack.size());
			ArrayList<Integer> values = new ArrayList<Integer>();
			while (!stack.isEmpty()) {
				TreeNode n = stack.pop();
				children.add(n);
				values.add(n.val);
			}
			if (reverse) {
				for (int i = 0, j = values.size() - 1; i < j; i++, j--) {

				}
			}
			result.add(values);
			reverse = !reverse;

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