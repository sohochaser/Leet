package com.leet.string.match;

/**
 * <ol>
 * <li>'?' Matches any single character.
 * <li>'*' Matches any sequence of characters (including the empty sequence).
 * 
 * <li>The matching should cover the entire input string (not partial).
 * 
 * <li>The function prototype should be:
 * <li>bool isMatch(const char *s, const char *p)
 * <li>Some examples:
 * <li>isMatch("aa","a") ¡ú false
 * <li>isMatch("aa","aa") ¡ú true
 * <li>isMatch("aaa","aa") ¡ú false
 * <li>isMatch("aa", "*") ¡ú true
 * <li>isMatch("aa", "a*") ¡ú true
 * <li>isMatch("ab", "?*") ¡ú true
 * <li>isMatch("aab", "c*a*b") ¡ú false
 * </ol>
 * 
 * @author Allen
 * 
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (p != null && p.equals("*")) {
			return true;
		}
		int[][] memo = new int[s.length() + 1][p.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j <= p.length(); j++) {
				memo[i][j] = -1;
			}
		}
		for (int i = 1; i <= s.length(); i++) {
			memo[i][0] = 0;
		}

		return check(s, p, memo);
	}

	private boolean check(String s, String reg, int[][] memo) {
		if (reg.length() == 1) {
			if (reg.equals("*")) {
				return true;
			} else if (s.length() == 1 && (reg.equals(s) || reg.equals("?"))) {
				return true;
			}
			return false;
		}
		int i = 0;
		int j = 0;
		for (i = s.length() - 1, j = reg.length() - 1; i >= 0 && j >= 0; i--, j--) {
			char c = reg.charAt(j);
			if (c == '*') {
				break;
			}
			if (c == '?') {
				continue;
			}

			if (c != s.charAt(i)) {
				return false;
			}
		}
		if (i == -1 || j == -1) {
			if (i == -1) {
				if (j == -1) {
					return true;
				}
				while (j >= 0) {
					if (reg.charAt(j) != '*') {
						return false;
					}
					j--;
				}
				return true;
			}
			if (j == -1) {
				return false;
			}
		}
		String ss = s.substring(0, i + 1);
		while (j > 0 && reg.charAt(j - 1) == '*') {
			j--;
		}
		String sreg = reg.substring(0, j);
		for (int k = 1; k <= (i + 1); k++) {
			if (memo[k][j] == -1) {
				memo[k][j] = check(ss.substring(0, k), sreg, memo) ? 1 : 0;
			}
			if (memo[k][j] == 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WildcardMatching w = new WildcardMatching();
		// System.out.println(w.isMatch("aa", "a"));// false
		// System.out.println(w.isMatch("aa", "aa"));// true
		// System.out.println(w.isMatch("aaa", "aa"));// false
		// System.out.println(w.isMatch("aa", "*"));// true
		// System.out.println(w.isMatch("aa", "a*"));// true
		// System.out.println(w.isMatch("ab", "?*"));// true
		// System.out.println(w.isMatch("aab", "c*a*b"));// false
		System.out.println(w.isMatch("b", "*?*?*"));
	}
}