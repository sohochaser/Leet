package com.leet.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <ol>
 * <li>Given a string s, partition s such that every substring of the partition
 * is a palindrome.
 * <li>Return all possible palindrome partitioning of s.
 * <li>For example, given s = "aab",
 * <li>Return
 * </ol>
 * <code>
  [
    ["aa","b"],
    ["a","a","b"]
  ]
  </code>
 * 
 * @author Allen
 * 
 */
public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		Map<Integer, ArrayList<ArrayList<String>>> result = new HashMap<Integer, ArrayList<ArrayList<String>>>();
		ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0) {

			return groups;
		}
		result.put(0, groups);
		check(s, result);
		return result.get(s.length());
	}

	public void check(String s,
			Map<Integer, ArrayList<ArrayList<String>>> result) {
		if (s.length() == 1) {
			ArrayList<ArrayList<String>> t = new ArrayList<ArrayList<String>>();
			t.add(new ArrayList<String>());
			t.get(0).add(s.substring(0, 1));
			result.put(s.length(), t);
		} else {
			ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
			for (int i = s.length() - 1; i >= 0; i--) {
				String sub = s.substring(i);
				if (isPalindrome(sub)) {
					if (i == 0) {
						ArrayList<String> group = new ArrayList<String>();
						group.add(sub);
						groups.add(group);
					} else {
						if (result.get(i) == null) {
							check(s.substring(0, i), result);// /!!!
						}
						ArrayList<ArrayList<String>> exist = result.get(i);
						for (ArrayList<String> l : exist) {
							ArrayList<String> group = new ArrayList<String>();
							group.addAll(l);
							group.add(sub);
							groups.add(group);
						}
					}
				}
			}
			result.put(s.length(), groups);
		}
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt((len - 1 - i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "aabb";
		ArrayList<ArrayList<String>> t = new PalindromePartitioning()
				.partition(s);
		for (ArrayList<String> l : t) {
			System.out.println(l);
		}
	}
}
