package com.leet.nb;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 */
public class MinimumDepth {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return find(root, 1, Integer.MAX_VALUE);
	}

	int find(TreeNode root, int level, int min) {
		if (level >= min) {
			return min;
		}
		if (root.left == null && root.right == null) {
			int depth = level;
			if (depth < min) {
				return depth;
			}
			return min;
		}

		int curentMin = min;
		if (root.left != null) {
			int m = find(root.left, level + 1, curentMin);
			if (m < curentMin) {
				curentMin = m;
			}
		}

		if (root.right != null) {
			int m = find(root.right, level + 1, curentMin);
			if (m < curentMin) {
				curentMin = m;
			}
		}
		return curentMin;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.genTree();
		// root = new TreeNode(2);
		// root.left = new TreeNode(1);
		int depth = new MinimumDepth().minDepth(root);

		System.out.println(depth);
	}
}