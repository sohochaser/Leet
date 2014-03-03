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

		for (int i = p.length() - 1, k = s.length() - 1; k >= 0 && i >= 0; i--) {
			char c = p.charAt(i);
			if (c != '.' && c != '*') {
				if (k >= 0 && s.charAt(k) != c) {
					return false;
				}
				k--;
			} else if (c == '.') {
				k--;
			} else {

			}
		}
		return false;
	}

	private boolean check(String s, String p) {
		int i = 0, j = 0;
		for (i = s.length() - 1, j = p.length() - 1; i >= 0 && j >= 0; i--, j--) {
			char c = p.charAt(i);
			if (c == '.' || c == '*') {
				break;
			}
			if (c == '.') {
				continue;
			}

			if (c != s.charAt(i)) {
				return false;
			}
		}
		if (i == 0 || j == 0) {
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
		}

		return true;
	}
}