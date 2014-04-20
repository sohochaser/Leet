package com.leet.dp;

import java.util.ArrayList;

/**
 * <ol>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * </ol>
 * <code>
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
</code>
 * <ol>
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int[] dp = new int[triangle.size() + 2];
		for (int i = 0; i < triangle.size(); i++) {
			ArrayList<Integer> row = triangle.get(i);
			int preRow = row.size() - 1;
			for (int j = row.size() - 1; j >= 0; j--) {
				int min = dp[j - 1 > 0 ? j - 1 : 0];
				for (int k = (j - 1 > 0 ? j - 1 : 0); k < preRow
						&& k <= j; k++) {
					if (dp[k] < min) {
						min = dp[k];
					}
				}
				dp[j + 2] = min + row.get(j);
			}
			for (int k = 0; k < row.size(); k++) {
				dp[k] = dp[k + 2];
			}
		}
		int min = dp[0];
		for (int i = 1; i < dp.length - 2; i++) {
			if (min > dp[i]) {
				min = dp[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> tr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		tr.add(a);

		a = new ArrayList<Integer>();
		a.add(3);
		a.add(4);
		tr.add(a);

		a = new ArrayList<Integer>();
		a.add(6);
		a.add(5);
		a.add(7);
		tr.add(a);

		a = new ArrayList<Integer>();
		a.add(4);
		a.add(1);
		a.add(8);
		a.add(3);
		tr.add(a);

		// System.out.println(new Triangle().minimumTotal(tr));

		tr = new ArrayList<ArrayList<Integer>>();
		a = new ArrayList<Integer>();
		a.add(-1);
		tr.add(a);

		a = new ArrayList<Integer>();
		a.add(3);
		a.add(2);
		tr.add(a);

		a = new ArrayList<Integer>();
		a.add(-3);
		a.add(1);
		a.add(-1);
		tr.add(a);

		System.out.println(new Triangle().minimumTotal(tr));
	}
}
