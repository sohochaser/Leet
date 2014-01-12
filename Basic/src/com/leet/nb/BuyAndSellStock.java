package com.leet.nb;

public class BuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		return find(prices,prices.length-1);
	}

	public int find(int[] arr, int maxIdx) {
		if (maxIdx < 1) {
			return 0;
		}
		int min = arr[0];
		int minIdx = 0;
		for (int i = 1; i <= maxIdx; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIdx = i;
			}
		}

		// Find right max
		int maxRight = 0;
		for (int i = minIdx + 1; i <= maxIdx; i++) {
			int tmp = arr[i] - min;
			if (tmp > maxRight) {
				maxRight = tmp;
			}
		}
		int maxLeft = 0;
		if (minIdx == 2) {
			maxLeft = arr[1] - arr[0];
		} else if (minIdx > 2) {
			maxLeft = find(arr, minIdx - 1);
		}

		if (maxRight > maxLeft) {
			return maxRight;
		} else {
			return maxLeft;
		}
	}

	public static void main(String[] args) {
		BuyAndSellStock b=new BuyAndSellStock();
		int[] a = new int[] {};
		int[] a1 = new int[] { 1 };
		int[] a2 = new int[] { 1, 2 };
		int[] a3 = new int[] { 2, 1 };
		int[] a4 = new int[] { 1, 2, 3, 4 };
		int[] a5 = new int[] { 4, 3, 2, 1 };
		System.out.println(b.maxProfit(a));
		System.out.println(b.maxProfit(a1));
		System.out.println(b.maxProfit(a2));
		System.out.println(b.maxProfit(a3));
		System.out.println(b.maxProfit(a4));
		System.out.println(b.maxProfit(a5));
	}
}