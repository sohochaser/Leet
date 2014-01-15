package com.leet.sort;

/**
 * <ol>
 * <li>Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <li>Note: You may assume that A has enough space to hold additional elements from B. The number
 * of elements initialized in A and B are m and n respectively.
 * </ol>
 * <p>
 * Created on Jan 14, 2014
 * 
 * @author Allen Yan
 */
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
        int bRightIdx = n;
        for (int i = 0; i < n; i++) {
            if (b[i] < end) {
                continue;
            } else {
                hole = i + 1;
                bRightIdx = i;
                break;
            }
        }

        // NB elements will insert into the a;(n-nb) will append to the end of a.
        int rightIdx = m + hole - 1;
        for (int j = (hole - 1); j >= 0; j--) {
            for (int i = m - 1; i >= 0 && hole > 0; i--) {
                if (b[j] > a[i]) {
                    int k = rightIdx;
                    for (; k >= (i + 1); k--) {
                        a[rightIdx--] = a[k];
                    }
                    a[rightIdx--] = b[j];
                    hole--;
                } else {
                    break;
                }
            }
        }

        for (int i = bRightIdx, j = (m + bRightIdx); i < n; i++, j++) {
            a[j] = b[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, -1, -1, -1 };
        int[] b = new int[] { 2 };
        new Merge().merge(a, 1, b, b.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}