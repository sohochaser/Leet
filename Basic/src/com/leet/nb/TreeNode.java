package com.leet.nb;

/**
 * Path Sum II.
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example:
 * 
 * Given the below binary tree and sum = 22, <code>
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
		return
		[
		   [5,4,11,2],
		   [5,8,4,5]
		]
</code> For example: Given the
 * below binary tree and sum = 22,
 */

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static void inOrder(TreeNode root) { // �и�����
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + "-");
			inOrder(root.right);
		}
	}

	public static TreeNode genTree() {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(4);

		node.left.left = new TreeNode(11);
		node.left.left.left = new TreeNode(7);
		node.left.left.right = new TreeNode(2);

		node.right = new TreeNode(8);
		node.right.left = new TreeNode(13);
		node.right.right = new TreeNode(4);

		node.right.right.left = new TreeNode(5);
		node.right.right.right = new TreeNode(1);

		TreeNode.inOrder(node);
		System.out.println();
		return node;
	}
}