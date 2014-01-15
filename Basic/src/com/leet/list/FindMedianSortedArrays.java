package com.leet.list;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int a[], int b[]) {

        if (a == null && b == null) {
            return 0;
        }
        if (a == null || b == null) {
            int[] c = (a != null) ? a : b;
            if (c.length == 0) {
                return 0;
            } else {
                int mid = c.length % 2;
                if (c.length % 2 == 0) {
                    return (c[mid - 1] + c[mid]) / 2;
                } else {
                    return c[mid];
                }
            }
        }
        int left = 0;
        int right = a.length + b.length;
        int al = 0;
        int ar = a.length;
        int bl = 0;
        int br = b.length;

        while (right > left) {
            if (a[al] < b[bl]) {
                left++;
            } else {
                bl++;
            }
            left++;

            if (a[ar] >= b[br]) {
                ar--;
            } else {
                br--;
            }
            right--;
        }
        return 0;
    }
}