package com.leet.nb;

public class MaxSubArray {
	public int maxSubArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		return maxSum(arr, 0, arr.length - 1);
	}

	public int maxSum(int[] arr, int l, int r) {
		if (l >= r) {
			return arr[l];
		}
		int m = (l + r) / 2;
		int lmax = 0;
		
		int lsum = 0;
		for (int i = m - 1; i >= 0; i--) {
			lsum += arr[i];
			if (lsum > lmax) {
				lmax = lsum;
			}
		}
		
		int rmax = 0;
		int rsum = 0;
		for (int i = m + 1; i <= r; i++) {
			rsum += arr[i];
			if (rsum > rmax) {
				rmax = rsum;
			}
		}
		int msum = arr[m];
		if (lmax > 0) {
			msum += lmax;
		}
		if (rmax > 0) {
			msum += rmax;
		}
		return getMaxOfThree(maxSum(arr, l, m - 1), maxSum(arr, m + 1, r), msum);
	}

	int getMaxOfThree(int a, int b, int c) {
		int max = a > b ? a : b;
		max = max > c ? max : c;
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(new MaxSubArray().maxSubArray(arr));
	}
}