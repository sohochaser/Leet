package com.leet.nb;

/**
 * <ol>
 * <li>Given an array of integers, every element appears three times except for
 * one. Find that single one.
 * 
 * <li>Note:
 * <li>Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * </ol>
 * 
 * @author Allen
 * 
 */
public class WordBreakII {

	int singleNumber(int A[]) {
		int[] x = new int[32];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < 32; j++) {
				x[j] += (A[i] >> j) & (1);
				x[j] %= 3;
			}
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res += (x[i] << i);
		}
		return res;
	}
}