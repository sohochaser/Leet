package com.leet.nb;

public class Merge {
	public void merge(int a[], int m, int b[], int n) {
		if (a == null || b == null) {
			return;
		}
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				a[i] = b[i];
			}
			return;
		}
		int end = a[m - 1];
		int hole = 0;
		int bRightIdx = 0;
		for (int i = 0; i < n; i++) {
			if (b[i] < end) {
				hole = i + 1;	
				bRightIdx = i+1;
				continue;
			} else {
				hole = i + 1;
				bRightIdx = i;
				break;
			}
		}

		// NB elements will insert into the a;(n-nb) will append to the end of
		int rightIdx = m + hole - 1;
		int aIdx = m - 1;
		for (int i = (hole - 1); i >= 0; i--) {
			while (aIdx >= 0&&a[aIdx] > b[i]) {
				a[rightIdx--] = a[aIdx];
				aIdx--;
			}
			a[rightIdx--] = b[i];			
		}

		for (int i = bRightIdx, j = (m + bRightIdx); i < n; i++, j++) {
			a[j] = b[i];
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, -1, -1, -1, -1, -1 };
		int[] b = new int[] { 1 };
		new Merge().merge(a, 1, b, b.length);
		p(a);
	}
	
	public static void p(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+"\t");
		}
		System.out.println();
	}
}