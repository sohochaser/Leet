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
public class RecoverTree {

	private static StringBuilder sb = new StringBuilder();

	public void recoverTree2(TreeNode root) {
		TreeNode pre = null;
		TreeNode n1 = null;
		TreeNode n2 = null;
		check2(root, pre, n1, n2);
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = n1.val;
	}

	private void check2(TreeNode root, TreeNode pre, TreeNode n1, TreeNode n2) {
		sb.append(">");
		if (root != null) {
			System.out.println(sb.toString() + root);
			check2(root.left, pre, n1, n2);
			if (pre == null) {
				System.out.println(sb.toString() + "PRE");
				pre = root;
			} else {
				if (root.val < pre.val) {
					if (n1 == null) {
						n1 = pre;
					} else {
						n2 = root;
					}
					pre = root;
				}
			}
			System.out.println(sb.toString() + root + " -> " + pre);
			check2(root.right, pre, n1, n2);
		}
		sb.setLength(sb.length() - 1);
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
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(1);
		a.left = b;
		a.right = c;
		TreeNode.inOrder(a);
		System.out.println();
		new RecoverTree().recoverTree2(a);
		System.out.println();
		TreeNode.inOrder(a);
	}
}