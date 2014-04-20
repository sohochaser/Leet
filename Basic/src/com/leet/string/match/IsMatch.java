package com.leet.string.match;

/**
 * 
 * 
 * <ol>
 * <li>Implement regular expression matching with support for '.' and '*'.
 * 
 * <li>'.' Matches any single character.
 * <li>'*' Matches zero or more of the preceding element.
 * 
 * <li>The matching should cover the entire input string (not partial).
 * 
 * <li>The function prototype should be:
 * <li>bool isMatch(const char *s, const char *p)
 * 
 * <li>Some examples:
 * <li>isMatch("aa","a") ¡ú false
 * <li>isMatch("aa","aa") ¡ú true
 * <li>isMatch("aaa","aa") ¡ú false
 * <li>isMatch("aa", "a*") ¡ú true
 * <li>isMatch("aa", ".*") ¡ú true
 * <li>isMatch("ab", ".*") ¡ú true
 * <li>isMatch("aab", "c*a*b") ¡ú true
 * </ol>
 * 
 * @author Allen
 */
public class IsMatch {
	public boolean isMatch(String s, String p) {
		if (s == null && p == null) {
			return true;
		}
		if (s == null && p != null) {
			return false;
		}
		if (s != null && p == null) {
			return false;
		}
		if (s.isEmpty()) {
			return true;
		}
		return check(s, p);
	}

	private boolean check(String s, String p) {
		int i = 0, j = 0;
		for (i = s.length() - 1, j = p.length() - 1; i >= 0 && j >= 0; i--, j--) {
			char c = p.charAt(j);
			if (c == '*') {
				break;
			}
			if (c == '.') {
				continue;
			}

			if (c != s.charAt(i)) {
				return false;
			}
		}
		if (i == -1 || j == -1) {
			if (i != j) {
				return false;
			} else {
				return true;
			}
		}

		String ss = s.substring(0, i + 1);
		String sp = p.substring(0, j + 1);
		char c = sp.charAt(j - 1);
		if (c == '.') {
			return true;
		} else {
			while (i >= 0) {
				if (ss.charAt(i) != c) {
					break;
				}
				i--;
			}
		}

		if (i < 0 && j == 1) {
			return true;
		} else if (i < 0 && j > 1) {
			int tmp = j - 2;
			while (tmp >= 0 && sp.charAt(tmp) == '*') {
				tmp -= 2;
			}
			if (tmp == -1) {
				return true;
			}
			return false;
		}
		return check(ss.substring(i + 1), sp.substring(0, j - 1));
	}

	public static void main(String[] args) {
		System.out.println(new IsMatch().isMatch("aa", "aa"));// true
		System.out.println(new IsMatch().isMatch("aa", "a"));// false
		System.out.println(new IsMatch().isMatch("aaa", ".a"));// false
		System.out.println(new IsMatch().isMatch("aab", "c*a*b"));// true
		System.out.println(new IsMatch().isMatch("aaa", "ab*a"));// false
		System.out.println(new IsMatch().isMatch("aaa", "ab*ac*a"));// true!!!
	}
}