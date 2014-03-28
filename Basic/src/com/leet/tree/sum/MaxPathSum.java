package com.leet.tree.sum;

import com.leet.TreeNode;

public class MaxPathSum {

	private int ans = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxSum(root);
		return ans;

	}

	int maxSum(TreeNode root) {
		int left = 0;
		int right = 0;
		if (root.left != null) {
			left = maxSum(root.left);
		}

		if (root.right != null) {
			right = maxSum(root.right);
		}

		int local = root.val;		
		if (left > 0) {
			local += left;
		}

		if (right > 0) {
			local += right;
		}

		if (local > ans) {
			ans = local;
		}
		return root.val + Math.max(Math.max(0, left), right);
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);

		a.left = b;
		a.right = c;
		System.out.println(new MaxPathSum().maxPathSum(a));
	}
}