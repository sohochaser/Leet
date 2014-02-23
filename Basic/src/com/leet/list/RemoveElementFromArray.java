package com.leet.list;

/**
 * <ol>
 * <li>Given an array and a value, remove all instances of that value in place
 * and return the new length.
 * <li>The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 * <li>For example, A=[0,2,3,2,5] elem=2, you should return 3 and also make the
 * original A array like [0,3,5,2,2]. However, the problem description has
 * announced that order is okay, so your A might be [5,0,3,2,2] or whatever.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class RemoveElementFromArray {
	public int removeElement(int[] arr, int elem) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			while (left < right && arr[left] != elem) {
				left++;
			}
			while (left < right && arr[right] == elem) {
				right--;
			}
			if (left < right) {
				arr[left] = arr[right];
				arr[right] = elem;
			}
		}
		if (arr[left] == elem) {
			return left;
		} else {
			return left + 1;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 0, 2, 3, 2, 5 };
		int len = new RemoveElementFromArray().removeElement(a, 2);
		for (int i = 0; i < len; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}