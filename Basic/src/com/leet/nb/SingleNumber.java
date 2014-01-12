package com.leet.nb;

public class SingleNumber {
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result ^= A[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 3, 4, 5, 6, 4, 5, 3, 2 };
		SingleNumber s = new SingleNumber();

		System.out.println(s.singleNumber(a));
	}
}

/**
 * Single Number Total Accepted: 8531 Total Submissions: 18795 My Submissions
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 */
