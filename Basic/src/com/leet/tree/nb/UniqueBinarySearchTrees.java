package com.leet.tree.nb;

/**
 * <ol>
 * <li>DP.
 * <li>Unique Binary Search Trees.
 * <li>Given n, how many structurally unique BST's (binary search trees) that
 * store values 1...n?
 * 
 * <li>For example, Given n = 3, there are a total of 5 unique BST's. <code>
    1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   </code>
 * <ol>
 * 
 * @author Allen
 * 
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] a = new int[n];
		a[0] = 1;
		return fun(n, a);
	}

	int fun(int n, int[] arr) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				arr[i] = fun(i, arr);
			}
			if (arr[n - i - 1] == 0) {
				arr[n - i - 1] = fun(n - i - 1, arr);
			}
			total += arr[i] * arr[n - i - 1];
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTrees().numTrees(1));
		System.out.println(new UniqueBinarySearchTrees().numTrees(2));
		System.out.println(new UniqueBinarySearchTrees().numTrees(3));
		System.out.println(new UniqueBinarySearchTrees().numTrees(4));
	}
}