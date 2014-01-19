package com.leet.string;

/**
 * <ol>
 * <li>Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * <li>For example:
 * <li>"A man, a plan, a canal: Panama" is a palindrome.
 * <li>
 * "race a car" is not a palindrome.
 * <li>Note:
 * <li>Have you consider that the string might be empty? This is a good question
 * to ask during an interview.
 * <li>For the purpose of this problem, we define empty string as valid
 * palindrome.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int len = s.length();
		int offset = 'a' - 'A';
		for (int i = 0, j = len - 1; i < j;) {
			char lc = s.charAt(i);
			if (!validChar(lc)) {
				i++;
				continue;
			}
			char rc = s.charAt(j);
			if (!validChar(rc)) {
				j--;
				continue;
			}
			if (lc <= '9' && lc > '0') {
				if (lc != rc) {
					return false;
				}
				i++;
				j--;
			} else {
				if (lc != rc) {
					if ((lc - rc) != offset && (rc - lc) != offset) {
						return false;
					}
				}
				i++;
				j--;
			}
		}
		return true;// !!!!!!!
	}

	private boolean validChar(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		} else if (c >= 'a' && c <= 'z') {
			return true;
		} else if (c >= 'A' && c <= 'Z') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindrome("aba"));
		System.out.println(new ValidPalindrome()
				.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(new ValidPalindrome().isPalindrome("race a car"));
	}
}