package com.leet.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> sentences = new ArrayList<String>();

		if (s == null || s.length() == 0)
			return sentences;

		Map<String, Set<String>> memo = new HashMap<String, Set<String>>();
		split(s, memo, dict);
		sentences.addAll(memo.get(s));
		return sentences;
	}

	private void split(String s, Map<String, Set<String>> memo, Set<String> dict) {
		Set<String> res = new HashSet<String>();
		if (dict.contains(s)) {
			res.add(s);
		}
		if (s.length() == 1) {
			memo.put(s, res);
			return;
		}
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if ((memo.containsKey(left) && memo.get(left).isEmpty())
					|| (memo.containsKey(right) && memo.get(right).isEmpty())) {
				continue;
			}
			if (!memo.containsKey(left)) {
				split(left, memo, dict);
				if (memo.get(left).isEmpty()) {
					continue;
				}
			}
			if (!memo.containsKey(right)) {
				split(right, memo, dict);
				if (memo.get(right).isEmpty()) {
					continue;
				}
			}

			Set<String> leftSet = memo.get(left);
			Set<String> rightSet = memo.get(right);
			if (!rightSet.isEmpty() && !leftSet.isEmpty()) {
				for (String rightWords : rightSet) {
					for (String leftWords : leftSet) {
						res.add(leftWords + " " + rightWords);
						System.out.println(">>>\t" + leftWords + " - "
								+ rightWords);
					}
				}
			}
		}
		memo.put(s, res);
	}

	ArrayList<String> check(String s, int idx, Set<String> dict,
			List<String> tmp) {
		ArrayList<String> result = new ArrayList<String>();
		if (idx >= s.length()) {
			return new ArrayList<String>();
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = idx + 1; i <= s.length(); i++) {
				String tmpStr = s.substring(idx, i);
				if (dict.contains(tmpStr)) {
					if (i < s.length() && tmp.get(i) == null) {
						check(s, i, dict, tmp);
					}

					if (sb.length() > 0) {
						sb.append(" ");
					}
					sb.append(tmpStr);
					if (i < s.length() && tmp.get(i).length() > 0) {
						sb.append(" ");
						sb.append(tmp.get(i));
					}
					result.add(sb.toString());
				}
			}
			tmp.set(idx, sb.toString());
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(new WordBreak2().wordBreak(s, dict).toString());
		dict.clear();
		dict.add("a");
		s = "a";
		System.out.println(new WordBreak2().wordBreak(s, dict).toString());
		dict.clear();
		s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		s = "aaaaaaa";
		dict.add("aaaa");
		dict.add("aa");
		dict.add("a");
		System.out.println(new WordBreak2().wordBreak(s, dict).toString());
	}
}