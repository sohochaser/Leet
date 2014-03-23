package com.leet.sort;

/**
 * <ol>
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class SortColors {
	public void sortColors(int[] a) {
		for (int i = 0, j = a.length - 1; i < a.length && i < j;) {
			while (a[i] == 0 && i < j) {
				i++;
			}
			while (a[j] == 2 && i < j) {
				j--;
			}
			if (i < j) {
				if (a[i] == 2) {
					a[i] = a[j];
					a[j--] = 2;
				} else if (a[j] == 0) {
					a[j] = a[i];
					a[i++] = 0;
				} else {
					int k = i;
					while (k <= j && a[k] == 1) {
						k++;
					}
					if (k > j) {
						break;
					} else {
						if (a[k] == 0) {
							a[k] = a[i];
							a[i++] = 0;
						} else {
							a[k] = a[j];
							a[j--] = 2;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 1 };
		new SortColors().sortColors(a);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}