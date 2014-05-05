package com.leet.list;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * <p>
 * Created on Jan 16, 2014 1
 * 
 * @author Allen Yan
 */
public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int a[], int b[]) {

		if ((a == null && b == null)) {
			return 0;
		}
		if (a == null || b == null || a.length == 0 || b.length == 0) {
			int[] c = (a != null && a.length != 0) ? a : b;
			if (c.length == 0) {
				return 0;
			} else {
				int mid = c.length / 2;
				if (c.length % 2 == 0) {
					return (c[mid - 1] + c[mid]) / 2.0;
				} else {
					return c[mid];
				}
			}
		}
		int total = a.length + b.length;
		boolean isOdd = (total) % 2 != 0;
		int mid = total > 2 ? (total / 2) + 1 : 0;
		return 0;

	}

	public static void main(String[] args) {
		int[] a = new int[] { 1 };
		int[] b = new int[] { 2, 3 };
		System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(
				a, b));
	}
}