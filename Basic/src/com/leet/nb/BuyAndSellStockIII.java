package com.leet.nb;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author Allen
 * 
 */
public class BuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 1) {
			return 0;
		}
		int min = prices[0];
		int[] left = new int[prices.length];// max profit for 0 to index

		for (int i = 1; i < prices.length; i++) {
			min = min(min, prices[i]);
			left[i] = max(left[i - 1], prices[i] - min);
		}

		int max = prices[prices.length - 1];
		int[] right = new int[prices.length];// max profit for index to right
		for (int i = prices.length - 2; i >= 0; i--) {
			max = max(max, prices[i]);
			right[i] = max(right[i + 1], max - prices[i]);
		}
		int total = 0;
		for (int i = 0; i < prices.length; i++) {
			total = max(total, (left[i] + right[i]));
		}
		return total;
	}

	int min(int a, int b) {
		return a < b ? a : b;
	}

	int max(int a, int b) {
		return a > b ? a : b;
	}

	int max(int[] prices, int left, int r) {
		if (r == 0 || left == prices.length - 1) {
			return 0;
		}
		int min = left;
		int max = 0;
		for (int i = left + 1; i <= r; i++) {
			if (prices[i] > prices[i - 1]) {
				if ((prices[i] - prices[min]) > max) {
					max = prices[i] - prices[min];
				}
			} else {
				if (prices[i] < prices[min]) {
					min = left;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		BuyAndSellStockIII b = new BuyAndSellStockIII();
		int[] a = new int[] {};
		int[] a1 = new int[] { 1 };
		int[] a2 = new int[] { 1, 2 };
		int[] a21 = new int[] { 4, 1, 2 };
		int[] a3 = new int[] { 2, 1 };
		int[] a4 = new int[] { 1, 2, 3, 4 };
		int[] a5 = new int[] { 4, 3, 2, 1 };
		// System.out.println(b.maxProfit(a));
		// System.out.println(b.maxProfit(a1));
		// System.out.println(b.maxProfit(a2));
		System.out.println(b.maxProfit(a21));
		System.out.println(b.maxProfit(a3));
		System.out.println(b.maxProfit(a4));
		System.out.println(b.maxProfit(a5));
	}
}