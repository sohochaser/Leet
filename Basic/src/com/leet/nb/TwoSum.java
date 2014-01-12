package com.leet.nb;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] a = new int[] { 0, 0 };
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == target - numbers[j]) {
					a[0] = i + 1;
					a[1] = j + 1;
					return a;
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a=new int[]{3,2,4};
		System.out.println(new TwoSum().twoSum(a, 6));
	}
}
