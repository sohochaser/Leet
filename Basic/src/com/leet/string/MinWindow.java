package com.leet.string;

/**
 * <ol>
 * <li>Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * <li>For example,
 * <li>S = "ADOBECODEBANC"
 * <li>T = "ABC"
 * <li>Minimum window is "BANC".
 * <li>Note:
 * <li>If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * <li>If there are multiple such windows, you are guaranteed that there will
 * always be only one unique minimum window in S.
 * <li>
 * 
 * </ol>
 * <a href="http://www.2cto.com/kf/201309/246423.html>ref</a> 
 * @author Allen
 * 
 */
public class MinWindow {
	public String minWindow(String s, String t) {

		if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
			return "";
		}

		if (s.length() < t.length()) {
			return "";
		}
		int[] data = new int[256];
		int num;
		int[] tar = new int[256];

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < t.length(); i++) {
			tar[t.charAt(i)]++;
		}

		int i, j;
		int left = 0, right = 0;
		num = 0;
		for (i = 0, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (num < t.length()) {
				if (data[c] < tar[c]) {
					num++;
				}
				data[c]++;
			}
			if (num == t.length()) {
				while (j <= i && data[s.charAt(j)] - 1 >= tar[s.charAt(j)]) {
					data[s.charAt(j)]--;
					j++;
				}
				if (min > (i - j + 1)) {
					left = j;
					right = i;
					min = i - j + 1;
				}

				while (j <= i && num == t.length()) {

					data[s.charAt(j)]--;
					if (data[s.charAt(j)] < tar[s.charAt(j)]) {
						num--;
					}
					j++;
				}
			}
		}

		if (min < Integer.MAX_VALUE) {
			return s.substring(left, right + 1);
		}
		return "";
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(new MinWindow().minWindow(s, t));
	}
}