package com.leet.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leet.TreeNode;

/**
 * Maximum Depth of Binary Tree Total Accepted: 10845 Total Submissions: 24512
 * My Submissions Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author Allen
 * 
 */
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return check2(root);
	}

	/**
	 * Recursive solution.
	 * 
	 * @param root
	 * @return
	 */
	int check(TreeNode root) {
		if (root != null) {
			return Math.max(1 + check(root.left), 1 + check(root.right));
		} else {
			return 0;
		}
	}

	/**
	 * Non recursive solution.
	 * 
	 * @param root
	 * @return
	 */
	int check2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int depth = 0;
		List<TreeNode> list = new ArrayList<TreeNode>();
		while (!stack.isEmpty()) {
			depth++;
			while (!stack.empty()) {
				list.add(stack.pop());
			}
			for (TreeNode n : list) {
				if (n.left != null) {
					stack.push(n.left);
				}
				if (n.right != null) {
					stack.push(n.right);
				}
			}
			list.clear();
		}
		return depth;
	}
}