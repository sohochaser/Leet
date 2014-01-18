package com.leet.tree;

import java.util.Stack;

import com.leet.TreeNode;

/**
 * <ol>
 * <li>Given a binary tree, check whether it is a mirror of itself (ie,
 * symmetric around its center).
 * <li>For example, this binary tree is symmetric:
 * 
 * <li>1
 * <li>/ \
 * <li>2 2
 * <li>/ \ / \
 * <li>3 4 4 3
 * 
 * <li>But the following is not:
 * <li>1
 * <li>/ \
 * <li>2 2
 * <li>\ \
 * <li>3 3 Note:
 * </ol>
 * 
 * @author Allen
 * 
 */
public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSame(root);
	}

	public boolean isSame(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (stack.size() > 0) {
			TreeNode[] nodes = new TreeNode[stack.size()];
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = stack.pop();
			}

			if (nodes.length % 2 != 0) {
				if (nodes.length == 1) {
					if (nodes[0] != root) {
						return false;
					}
				} else {
					return false;
				}
			}

			int mid = nodes.length / 2;
			for (int i = 0; i < mid; i++) {
				TreeNode l = nodes[i];
				TreeNode r = nodes[nodes.length - i - 1];

				if (l == null || r == null) {
					if (l != r) {
						return false;
					}
				} else if (l.val != r.val) {
					return false;
				}
			}
			int leftNb = 0;
			int rightNb = 0;
			for (int i = nodes.length - 1; i >= 0; i--) {
				if (nodes[i] == null) {
					continue;
				}
				if (nodes[i].right != null) {
					stack.push(nodes[i].right);
					rightNb++;
				} else {
					stack.push(null);
				}
				if (nodes[i].left != null) {
					stack.push(nodes[i].left);
					leftNb++;
				} else {
					stack.push(null);
				}
			}
			if (leftNb != rightNb) {
				return false;
			}

			if (leftNb == 0) {
				stack.clear();
			}
		}
		return true;
	}

	public boolean isSymmetricR(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSameR(root.left, root.right);
	}

	/**
	 * Recursive
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public boolean isSameR(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSameR(left.left, right.right)
				&& isSameR(left.right, right.left);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;

		TreeNode ln = new TreeNode(3);
		TreeNode rn = new TreeNode(3);

		left.right = ln;
		right.left = rn;

		System.out.println("R: " + new IsSymmetric().isSymmetricR(root));
		System.out.println(new IsSymmetric().isSymmetric(root));
	}
}