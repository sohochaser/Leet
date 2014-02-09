package com.leet.nb;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {

		int n = s.length();

		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			if (dp[i - 1]) {
				int idx = i - 1;
				for (int j = idx; j < n; j++) {
					String cur = s.substring(idx, j+1);
					if (dict.contains(cur)) {
						dp[j + 1] = true;
					}
				}
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		String s="a";
		Set<String> dict=new HashSet<String>();		
		 dict.add("a");
		//dict.add("gs");
		//dict.add("s");
		System.out.println(new WordBreak().wordBreak(s, dict));
	}
}