package com.leet.basic;

public class LongestSubString {
	/**
	 * longest sub string.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	static String check(String s1, String s2) {
		int[][] c = new int[s1.length() + 1][s2.length() + 1];
		int[][] b = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			c[i][0] = 0;
		}
		for (int j = 1; j <= s2.length(); j++) {
			c[0][j] = 0;
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				if (c1 == c2) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 0;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = 1;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = -1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		printLCS(b, s1, s2, s1.length(), s2.length(), sb);
		return sb.toString();
	}

	static void printLCS(int b[][], String s1, String s2, int i, int j,
			StringBuilder sb) {
		if (i == 0 || j == 0)
			return;
		if (b[i][j] == 0) {
			printLCS(b, s1, s2, i - 1, j - 1, sb);
			sb.append(s1.charAt(i - 1));
		} else if (b[i][j] == 1)
			printLCS(b, s1, s2, i - 1, j, sb);
		else
			printLCS(b, s1, s2, i, j - 1, sb);
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		String sub = check(s, sb.toString());
		return s;
	}

	public static void main(String[] args) {
		String s = "abbcb";
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}

		System.out.println(check(s, sb.toString()));
	}
}
