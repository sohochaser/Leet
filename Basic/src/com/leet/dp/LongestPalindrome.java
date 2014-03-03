package com.leet.dp;

public class LongestPalindrome {
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		String[][] memo = new String[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			memo[i][i] = String.valueOf(s.charAt(i));
		}
		// return check(s, 0, s.length() - 1, memo);
		return check2(s);
	}

	String check(String s, int l, int r, String[][] memo) {
		if (l > r) {
			memo[l][r] = "";
		} else {
			if (memo[l][r] != null) {
				return memo[l][r];
			}
			char cl = s.charAt(l);
			char cr = s.charAt(r);
			String max = null;
			String b;
			String c;
			if (cl == cr) {
				if ((l + 1) <= (r - 1)) {
					max = cl + check(s, l + 1, r - 1, memo) + cr;
				} else if ((l + 1) == r) {
					return cl + "" + cr;
				}
			}
			b = check(s, l + 1, r, memo);
			c = check(s, l, r - 1, memo);
			if (max != null) {
				if (max.length() < b.length()) {
					max = b;
				}
			} else {
				max = b;
			}
			if (max.length() < c.length()) {
				max = c;
			}
			memo[l][r] = max;
		}
		return memo[l][r];
	}

	String check2(String s) {
		boolean dp[][] = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (i >= j) {
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
			}
		}

		int interval;
		int j;
		int i;
		int maxLen = 1;
		int rFrom = 0, rTo = 0;
		for (interval = 1; interval < s.length(); interval++) {
			for (i = 0; interval + i < s.length(); i++) {
				j = i + interval;
				if (s.charAt(i) != s.charAt(j)) {
					dp[i][j] = false;
				} else {
					dp[i][j] = dp[i + 1][j - 1];
					if (dp[i][j]) {
						if (interval + 1 > maxLen) {
							maxLen = interval + 1;
							rFrom = i;
							rTo = j;
						}
					}
				}
			}
		}
		return s.substring(rFrom, rTo+1);
	}

	public static void main(String[] args) {
		String s = "abababababababababababababababababababababababababababababababababababababababababa"
				+ "babababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababab"
				+ "ababababababababababababababababababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababababababa";
		s = "abbcb";
		System.out.println(new LongestPalindrome().longestPalindrome(s));
	}
}