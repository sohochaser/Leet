package com.leet.nb;

import java.util.ArrayList;
import java.util.List;

import com.leet.TreeNode;

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
public class PathSum {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		List<Integer> resultList = new ArrayList<Integer>();
		check(root, sum, resultList, result);
		return result;
	}

	public void check(TreeNode root, int sum, List<Integer> parentList,
			ArrayList<ArrayList<Integer>> r) {
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				ArrayList<Integer> c = new ArrayList<Integer>();
				for (Integer i : parentList) {
					c.add(i);
				}
				c.add(root.val);
				r.add(c);
			}
		}
		parentList.add(root.val);

		if (root.left != null) {
			check(root.left, sum - root.val, parentList, r);
		}

		if (root.right != null) {
			check(root.right, sum - root.val, parentList, r);
		}
		parentList.remove(parentList.size() - 1);
	}

	public static void main(String[] args) {
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

		inOrder(node);
		ArrayList<ArrayList<Integer>> l = new PathSum().pathSum(node, 22);
		System.out.println(l);
	}

	public static void inOrder(TreeNode root) { // ÖÐ¸ù±éÀú

		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + "-");
			inOrder(root.right);
		}
	}
}