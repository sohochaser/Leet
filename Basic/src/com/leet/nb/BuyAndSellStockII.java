package com.leet.nb;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author Allen
 * 
 */
public class BuyAndSellStockII {
	public int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i])
				total += prices[i + 1] - prices[i];
		}
		return total;
	}

	public static void main(String[] args) {
		BuyAndSellStockII b = new BuyAndSellStockII();
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