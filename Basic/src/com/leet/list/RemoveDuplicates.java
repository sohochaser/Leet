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
 * <p>
 * Created on Jan 16, 2014
 * 
 * @author Allen Yan
 */
public class RemoveDuplicates {
	
	//Start from begin, each time treat items of same value.
	public int removeDuplicates(int[] arr) {
		if (null == arr || arr.length == 0) {
			return 0;
		}
		int idx = 0;
		for (int i = 0; i < arr.length;) {
			int current = i;
			arr[idx++] = arr[current];
			i++;

			while (i < arr.length && arr[i] == arr[current]) {
				i++;
			}
		}
		return idx;
	}

	public int removeDuplicates1(int[] arr) {
		if (null == arr || arr.length == 0) {
			return 0;
		}
		int postValue = arr[arr.length - 1];
		int lastIndex = arr.length - 1;
		for (int i = arr.length - 2; i >= 0;) {
			int current = i;
			while (i >= 0 && arr[i] == postValue) {
				i--;
			}
			if (i < 0) {
				break;
			}
			postValue = arr[current];
			lastIndex = current;
			if (i != current) {
				for (int j = i + 1; j <= current; j++) {
					arr[j] = arr[i];
				}
				i = current;
			} else {
				i--;
			}
		}

		if (lastIndex > 0) {
			for (int i = lastIndex; i < arr.length; i++) {
				arr[i - lastIndex] = arr[i];
			}
		}
		return arr.length - lastIndex;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 5, 5 };
		int k = new RemoveDuplicates().removeDuplicates(a);
		for (int i = 0; i < k; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}