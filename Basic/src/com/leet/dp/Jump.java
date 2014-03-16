package com.leet.dp;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author Allen
 * 
 */
public class Jump {
	public boolean canJump(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return true;
		}
		int i = arr.length - 2;
		int min = 1;
		int max = 1;
		for (; i >= 0; i--) {
			int distance = arr.length - i - 1;
			int jump = arr[i];
			if (distance <= jump) {
				if (i == (arr.length - 2)) {
					max = 1;
				} else {
					max = max + 1;
				}
				min = 1;
				arr[i] = 0;
			} else {
				if (jump >= min) {
					arr[i] = 0;
					min = 1;
				} else {
					arr[i] = -1;
					min = min + 1;
				}
				max = max + 1;
			}
		}
		return arr[0] == 0;
	}

	public static void main(String[] args) {
		int[] a;
		a = new int[] { 2, 3, 1, 1, 4 };// true
		System.out.println(new Jump().canJump(a));
		a = new int[] { 3, 2, 1, 0, 4 };// false
		System.out.println(new Jump().canJump(a));

		a = new int[] { 1, 2, 3 };// true
		System.out.println(new Jump().canJump(a));

		a = new int[] { 1, 1, 1, 0 };
		System.out.println(new Jump().canJump(a));// true
	}
}