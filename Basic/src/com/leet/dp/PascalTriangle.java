package com.leet.dp;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * @author Allen
 * 
 */
public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (numRows < 0) {
			return result;
		}
		int[] dp = new int[numRows + 1];

		for (int i = 0; i < numRows; i++) {
			dp[0] = 1;
			dp[i] = 1;
			for (int k = i - 1; k > 0; k--) {
				dp[k] = dp[k] + dp[k - 1];
			}

			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int k = 0; k <= i; k++) {
				row.add(dp[k]);
			}
			result.add(row);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new PascalTriangle().generate(0));
		System.out.println(new PascalTriangle().generate(1));
		System.out.println(new PascalTriangle().generate(2));
		System.out.println(new PascalTriangle().generate(3));
	}

}