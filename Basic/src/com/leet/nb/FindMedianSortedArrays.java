package com.leet.nb;

public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int a[], int b[]) {

		int total = (a.length + b.length);
		if (total == 0) {
			return 0;
		}

		int mid = total / 2;
		boolean even = total % 2 == 0;

		int i = 0;
		int j = 0;
		int idx = 0;
		while (true) {
			if (i >= a.length || j >= b.length) {
				break;
			}
			while (i < a.length && a[i] < b[j] && idx < mid) {
				i++;
				idx++;
			}
			while (i < a.length && j < b.length && a[i] > b[j] && idx < mid) {
				j++;
				idx++;
			}
			if (idx == mid) {
				break;
			}
		}
		if (idx < mid || a.length == 0 || b.length == 0) {
			int[] c;
			int k;
			if (i == a.length) {
				c = b;
				k = j;
			} else {
				c = a;
				k = i;
			}
			for (; k < c.length; k++, idx++) {
				if (idx == mid) {
					if (even) {
						return (c[i] + c[j + 1]) / 2.0;
					}
				} else {
					return c[i];
				}
			}
		}
		if (even) {
			if (a[i + 1] < b[j]) {
				return (a[i] + a[i + 1]) / 2.0;
			} else {
				return (a[i] + b[j]) / 2.0;
			}
		} else {
			return a[i];
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1 };
		int[] b = new int[] { 2 };
		System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(
				a, b));
	}
}