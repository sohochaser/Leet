package com.leet.tree;

import java.util.ArrayList;
import java.util.List;

import com.leet.TreeNode;

/**
 * <ol>
 * <li>Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * <li>Recover the tree without changing its structure.
 * 
 * <li>Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * </ol>
 * 
 * @author Allen
 * 
 */
public class RecoverTreeFix {
	TreeNode pre = null;
	TreeNode n1 = null;
	TreeNode n2 = null;

	public void recoverTree(TreeNode root) {
		check(root);
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
	}

	private void check(TreeNode root) {
		if (root != null) {
			check(root.left);
			if (pre != null) {
				if (root.val < pre.val) {
					if (n1 == null) {
						n1 = pre;
						n2 = root;
					} else {
						n2 = root;
					}
				}
			}
			pre = root;
			check(root.right);
		}
	}

	public void recoverTree1(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		check1(root, list);
		TreeNode n1 = null;
		TreeNode n2 = null;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).val < list.get(i - 1).val) {
				if (n1 == null) {
					n1 = list.get(i - 1);
					n2 = list.get(i);
				} else {
					n2 = list.get(i);
				}
			}
		}
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
	}

	private void check1(TreeNode root, List<TreeNode> list) {
		if (root != null) {
			if (root.left != null) {
				check1(root.left, list);
			}
			list.add(root);
			if (root.right != null) {
				check1(root.right, list);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(2);
		a.left = b;
		a.right = c;
		TreeNode.inOrder(a);
		System.out.println();
		new RecoverTreeFix().recoverTree(a);
		System.out.println();
		TreeNode.inOrder(a);
	}
}