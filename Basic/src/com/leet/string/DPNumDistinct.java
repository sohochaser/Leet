package com.leet.string;

/**
 * <ol>
 * <li>Given a string S and a string T, count the number of distinct
 * subsequences of T in S.
 * 
 * <li>A subsequence of a string is a new string which is formed from the
 * original string by deleting some (can be none) of the characters without
 * disturbing the relative positions of the remaining characters. (ie, "ACE" is
 * a subsequence of "ABCDE" while "AEC" is not).
 * 
 * <li>Here is an example:
 * <li>S = "rabbbit", T = "rabbit"
 * 
 * <li>Return 3
 * </ol>
 * 
 * @author Allen
 * 
 */
public class DPNumDistinct {
	public int numDistinct(String s, String t) {
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= s.length(); i++) {
			dp[0][i] = 1;
		}
		for (int j = 1; j <= t.length(); j++) {
			dp[j][0] = 0;
		}

		for (int i = 1; i <= t.length(); i++) {
			char c = t.charAt(i - 1);
			for (int j = 1; j <= s.length(); j++) {
				dp[i][j] = dp[i][j - 1];
				if (c == s.charAt(j - 1)) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		return dp[t.length()][s.length()];
	}

	public static void main(String[] args) {
		System.out.println(new DPNumDistinct().numDistinct("aaa", "a"));
	}
}