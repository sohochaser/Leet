package com.leet.nb;

public class SearchInsert {
    public int searchInsert(int[] arr, int target) {
        if (null == arr | arr.length == 0) {
            return 0;
        }
        return check(arr, 0, arr.length - 1, target);
    }

    public int check(int[] arr, int left, int right, int target) {
        if (left >= right) {
            if (target == arr[left]) {
                return left;
            }
            if (left > right) {
                if (target > arr[left]) {
                    return left + 1;
                } else {
                    // !!! Left element should move to right if the value is element
                    // should be replaced.
                    return left;

                }
            } else {
                if (target > arr[right]) {
                    return right + 1;
                } else {
                    return right;
                }
            }
        } else {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                return check(arr, mid + 1, right, target);
            } else {
                return check(arr, left, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 5, 7, 9, 10 };
        for (int i = 8; i <= 8; i++) {
            System.out.println("i: " + i + "\t" + new SearchInsert().searchInsert(arr, i));
        }

    }
}