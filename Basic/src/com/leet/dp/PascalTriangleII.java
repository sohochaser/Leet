package com.leet.dp;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author Allen
 * 
 */
public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (rowIndex < 0) {
			return result;
		}
		int[] dp = new int[rowIndex + 1];
		dp[0] = 1;
		for (int i = 1; i <= rowIndex; i++) {
			dp[0] = 1;
			dp[i] = 1;
			for (int k = i - 1; k > 0; k--) {
				dp[k] = dp[k] + dp[k - 1];
			}
		}
		for (int i = 0; i < dp.length; i++) {
			result.add(dp[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new PascalTriangleII().getRow(0));
		System.out.println(new PascalTriangleII().getRow(1));
		System.out.println(new PascalTriangleII().getRow(2));
		System.out.println(new PascalTriangleII().getRow(3));
	}

}