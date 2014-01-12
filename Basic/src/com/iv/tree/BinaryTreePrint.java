package com.iv.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePrint {

	public static void preOrder(BinaryTree root) { // 先根遍历
		if (root != null) {
			System.out.print(root.data + "-");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void inOrder(BinaryTree root) { // 中根遍历

		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + "-");
			inOrder(root.right);
		}
	}

	public static void postOrder(BinaryTree root) { // 后根遍历

		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + "-");
		}
	}

	public static void main(String[] str) {
		int[] array = { 12, 76, 35, 22, 16, 48, 90, 46, 9, 40 };
		BinaryTree root = new BinaryTree(array[0]); // 创建二叉树
		for (int i = 1; i < array.length; i++) {
			root.insert(root, array[i]); // 向二叉树中插入数据
		}
		System.out.println("先根遍历：");
		preOrder(root);
		System.out.println();
		System.out.println("中根遍历：");
		inOrder(root);
		System.out.println();
		System.out.println("后根遍历：");
		postOrder(root);

		preP(root);
		System.out.println();
		createTree();
	}

	public static void preP(BinaryTree root) {
		if (root == null) {
			return;
		}
		System.out.println("");
		Stack<BinaryTree> stack = new Stack<BinaryTree>();

		stack.push(root);

		while (!stack.empty()) {
			BinaryTree n = stack.pop();
			System.out.print(n.data + "-");

			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
	}

	public static void createTree() {
		int[] pre = new int[] { 12, 9, 76, 35, 22, 16, 48, 46, 40, 90 };
		int[] in = new int[] { 9, 12, 16, 22, 35, 40, 46, 48, 76, 90 };
		List<Integer> preOrder = new ArrayList<Integer>();
		List<Integer> inOrder = new ArrayList<Integer>();
		for (int i : pre) {
			preOrder.add(i);
		}
		for (int i : in) {
			inOrder.add(i);
		}
		Node node = constructBinaryTree(preOrder, inOrder);
		postP(node);
	}

	public static void postP(Node root) {
		if (root != null) {
			postP(root.left);
			postP(root.right);
			System.out.print(root.data + "-");
		}
	}

	public static BinaryTree cTree(int[] pre, int[] in, int length) {
		if (pre == null || pre.length == 0 || in == null || in.length == 0
				|| length == 0) {
			return null;
		}
		int first = pre[0];
		BinaryTree root = new BinaryTree(first);
		for (int i = 0; i < in.length; i++) {

		}
		return root;
	}

	public static Node constructBinaryTree(List<Integer> preOrder,
			List<Integer> inOrder) {
		Node node = null;
		List<Integer> leftPreOrder;
		List<Integer> rightPreOrder;
		List<Integer> leftInorder;
		List<Integer> rightInorder;
		int inorderPos;
		int preorderPos;

		if ((preOrder.size() != 0) && (inOrder.size() != 0)) {
			// Assign the first element of preorder traversal as root
			node = new Node();
			node.data = ((Integer) preOrder.get(0)).intValue();

			// Based upon the current node data seperate the traversals into
			// leftPreorder, rightPreorder,
			// leftInorder, rightInorder lists
			inorderPos = inOrder.indexOf(preOrder.get(0));
			leftInorder = inOrder.subList(0, inorderPos);
			rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());

			preorderPos = leftInorder.size();
			leftPreOrder = preOrder.subList(1, preorderPos + 1);
			rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());

			node.left = constructBinaryTree(leftPreOrder, leftInorder);
			node.right = constructBinaryTree(rightPreOrder, rightInorder);
		}

		return node;
	}
}