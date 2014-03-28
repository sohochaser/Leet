package com.leet.tree.sum;

import com.leet.TreeNode;

/**
 * <ol>
 * <li>Given a binary tree containing digits from 0-9 only, each root-to-leaf
 * path could represent a number.
 * 
 * <li>An example is the root-to-leaf path 1->2->3 which represents the number
 * 123.
 * 
 * <li>Find the total sum of all root-to-leaf numbers.
 * 
 * <li>For example, <code>
    1
   / \
  2   3
  </code>
 * 
 * <li>The root-to-leaf path 1->2 represents the number 12.
 * <li>The root-to-leaf path 1->3 represents the number 13.
 * 
 * <li>Return the sum = 12 + 13 = 25.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class SumNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		TreeNode sum = new TreeNode(root.val);
		check(root, sum);

		return getSum(sum);
	}

	private void check(TreeNode root, TreeNode sum) {
		int v = sum.val;
		if (root.left != null) {
			int lv = v * 10 + root.left.val;
			TreeNode l = new TreeNode(lv);
			sum.left = l;

			check(root.left, sum.left);
		}

		if (root.right != null) {//!!!
			int rv = v * 10 + root.right.val;
			TreeNode r = new TreeNode(rv);
			sum.right = r;
			check(root.right, sum.right);
		}
	}

	private int getSum(TreeNode root) {
		int sum = 0;
		if (root.left == null && root.right == null) {
			sum = root.val;
		} else {
			if (root.left != null && root.right != null) {
				sum = getSum(root.left) + getSum(root.right);
			} else if (root.left != null) {
				sum = getSum(root.left);
			} else {
				sum = getSum(root.right);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		//a.right = c;

		System.out.println(new SumNumbers().sumNumbers(a));
	}
}