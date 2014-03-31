package com.leet.tree;

import java.util.ArrayList;
import java.util.List;

import com.leet.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees.
 * <ol>
 * <li>{1,1} ->false
 * <li>{10,5,15,#,#,6,20} ->false
 * </ol>
 * 
 * @author Allen
 * 
 */
public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		List<Integer> list = new ArrayList<Integer>();
		travel(root, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) >= list.get(i)) { // >=
				return false;
			}
		}
		return true;
	}

	private void travel(TreeNode root, List<Integer> list) {
		if (root.left != null) {
			travel(root.left, list);
		}
		list.add(root.val);
		if (root.right != null) {
			travel(root.right, list);
		}
	}
}