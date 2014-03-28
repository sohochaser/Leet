package com.cc;

class Solution {
	public int solution(int[] R, int X, int M) {
		if (R.length * X > M) {
			return -1;
		}
		return M;
	}

	public int solution(int[] A) {
		if (A.length == 0) {
			return -1;
		}
		if (A.length == 1) {
			return 0;
		}
		long sum = 0L;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		long left = 0L;
		int i = 0;
		for (i = 0; i < A.length; i++) {
			sum = sum - A[i];			
			if (left == sum) {
				return i;
			}
			left = left + A[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { -7, 1, 5, 2, -4, 3, 0 };
		System.out.println(new Solution().solution(a));
	}
}
