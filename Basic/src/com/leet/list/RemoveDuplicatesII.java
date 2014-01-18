package com.leet.list;

/**
 * <ol>
 * <li>Given a sorted array, remove the duplicates in place such that each
 * element appear only once and return the new length.
 * <li>Do not allocate extra space for another array, you must do this in place
 * with constant memory.
 * <li>For example,
 * <li>Given input array A = [1,1,2],
 * <li>Your function should return length = 2, and A is now [1,2].
 * </ol>
 * 
 * 
 * <ol>
 * <li>Follow up for "Remove Duplicates":
 * <li>What if duplicates are allowed at most twice?
 * <li>For example,
 * <li>Given sorted array A = [1,1,1,2,2,3],
 * <li>Your function should return length = 5, and A is now [1,1,2,2,3].
 * </ol>
 * <p>
 * Created on Jan 16, 2014
 * 
 * @author Allen Yan
 */
public class RemoveDuplicatesII {
	public int removeDuplicates(int[] arr) {
		if (null == arr || arr.length == 0) {
			return 0;
		}
		int idx = 0;
		for (int i = 0; i < arr.length;) {
			int current = i;
			arr[idx++] = arr[current];
			i++;

			if (i < arr.length && arr[i] == arr[current]) {
				arr[idx++] = arr[i];
				i++;
				while (i < arr.length && arr[i] == arr[current]) {
					i++;
				}
			}
		}
		return idx;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3 };
		int k = new RemoveDuplicatesII().removeDuplicates(a);
		for (int i = 0; i < k; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}