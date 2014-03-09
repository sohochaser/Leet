package com.leet.tree.travel;

import java.util.ArrayList;
import java.util.Stack;

import com.leet.TreeNode;

/**
 * <code>
 * http://www.cnblogs.com/dolphin0520/archive/2011/08/25/2153720.html
 * </code>
 * 
 * @author Allen
 * 
 */
public class InorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode itr = root;
		while (itr != null || !stack.isEmpty()) {
			while (itr != null) {
				stack.push(itr);
				itr = itr.left;
			}
			if (!stack.isEmpty()) {
				TreeNode t = stack.pop();
				// System.out.println(t.val + "\t");
				result.add(t.val);
				if (t.right != null) {
					itr = t.right;
				}
			}
		}
		return result;
	}

	private void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + "\t");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);

		a.left = b;
		a.right = c;
		b.left = d;
		d.right = e;
		new InorderTraversal().inorder(a);
		System.out.println();
		new InorderTraversal().inorderTraversal(a);
	}
}