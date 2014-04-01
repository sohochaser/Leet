package com.leet.tree;

import com.leet.TreeNode;

public class IsBalanced {
	public boolean isBalanced(TreeNode root) {
		return check(root);

	}

	private boolean check(TreeNode root) {
		if (root == null) {
			return true;
		}
		int l = len(root.left);
		int r = len(root.right);
		if (l - r > 1 || (l - r) < -1) {
			return false;
		}
		return check(root.left) && check(root.right);
	}

	private int len(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = len(root.left);
		int r = len(root.right);
		if (l < r) {
			l = r;
		}
		return l + 1;
	}
}