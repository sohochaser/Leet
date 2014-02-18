package com.leet.nb;

import java.util.HashSet;
import java.util.Set;

/**
 * <ol>
 * <li>Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * <li>For example,
 * <li>Given [100, 4, 200, 1, 3, 2],
 * <li>The longest consecutive elements sequence is [1, 2, 3, 4]. Return its
 * length: 4.
 * 
 * <li>Your algorithm should run in O(n) complexity.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class LongestConsecutive {
	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}

		int max = 0;
		for (int i = 0; i < num.length; i++) {
			int len = 1;
			int tmpnum = num[i] + 1;
			while (set.contains(tmpnum)) {
				set.remove(tmpnum);
				len++;
				tmpnum++;
			}

			tmpnum = num[i] - 1;
			while (set.contains(tmpnum)) {
				set.remove(tmpnum);
				len++;
				tmpnum--;
			}

			if (len > max) {
				max = len;
			}

			if (max >= num.length) {
				break;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] num = new int[] { 100, 4, 200, 1, 3, 2 };
		System.out.println(new LongestConsecutive().longestConsecutive(num));
	}
}