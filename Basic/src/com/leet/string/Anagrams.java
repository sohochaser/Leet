package com.leet.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author Allen
 * 
 */
public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		int[] arr = new int[26];
		for (String str : strs) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = 0;
			}
			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'a']++;
			}

			StringBuilder sb = new StringBuilder();
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int k = 0; k < arr[i]; k++) {
					sb.append((char) ('a' + i));
					cnt++;
				}
				if (cnt == str.length()) {
					break;
				}
			}
			List<String> list = map.get(sb.toString());
			if (list == null) {
				list = new ArrayList<String>();
			}
			list.add(str);
			map.put(sb.toString(), list);
		}

		for (List<String> list : map.values()) {
			if (list.size() >= 2) {
				result.addAll(list);
			}
		}
		return result;
	}
}