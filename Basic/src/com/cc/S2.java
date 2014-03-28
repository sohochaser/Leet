package com.cc;

public class S2 {
	public int solution(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		if (arr.length == 1) {
			return arr[0];
		}

		int[] memo = new int[arr.length + 1];
		memo[0] = arr[0];

		int preMix = arr[0];
		int preMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int tmp = min(memo[i - 1], arr[i]);
			if(arr[i]>0){
				tmp = min(tmp,arr[i]+preMix);
			}
			preMix+=arr[i];
			preMax+=arr[i];
		}
		return 0;
	}

	public int min(int a, int b) {
		int k = Math.abs(a) < Math.abs(b) ? a : b;
		return Math.abs(k);
	}

}
