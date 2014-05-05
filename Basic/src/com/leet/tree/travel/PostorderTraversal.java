package com.leet.tree.travel;

import java.util.ArrayList;
import java.util.Stack;

import com.leet.TreeNode;

public class PostorderTraversal {
	// Check the root null.
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> out = new Stack<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty() && root != null) {
			root = stack.pop();
			out.push(root);
			if (root.left != null) {
				stack.push(root.left);
			}
			if (root.right != null) {
				stack.push(root.right);
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!out.isEmpty()) {
			result.add(out.pop().val);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		n.right = new TreeNode(3);
		n.left.left = new TreeNode(4);
		n.right.right = new TreeNode(5);
		System.out.println(new PostorderTraversal().postorderTraversal(null));
	}
}