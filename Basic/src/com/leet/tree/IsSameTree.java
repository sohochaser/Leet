package com.leet.tree;

import com.leet.TreeNode;

public class IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return check(p, q);
	}

	public boolean check(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;
		}
		if (p.val != q.val) {
			return false;
		}
		return check(p.left, q.left) && check(p.right, q.right);
	}
}