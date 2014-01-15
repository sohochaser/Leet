package com.leet.list;

/**
 * <ol>
 * <li>Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <li>(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <li>You are given a target value to search. If found in the array return its index, otherwise
 * return -1.
 * <li>You may assume no duplicate exists in the array.
 * </ol>
 * <p>
 * Created on Jan 15, 2014
 * 
 * @author Allen Yan
 */

public class SearchInRotatedSortedArray {
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int rotatedIdx = arr.length;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                rotatedIdx = i;
                break;
            }
        }
        if (rotatedIdx == arr.length) {
            return check(arr, 0, rotatedIdx - 1, target);
        } else {
            if (rotatedIdx == 1) {
                if (target == arr[0]) {
                    return 0;
                }
            }
            if (target >= arr[0] && target <= arr[rotatedIdx - 1]) {
                return check(arr, 0, rotatedIdx - 1, target);
            } else if (target >= arr[rotatedIdx] && target <= arr[arr.length - 1]) {
                return check(arr, rotatedIdx, arr.length - 1, target);
            } else {
                return -1;
            }
        }
    }

    private int check(int[] arr, int left, int right, int target) {
        if (left >= right) { // !!!
            if (target == arr[left]) {
                return left;
            } else {
                return -1;
            }
        } else {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return check(arr, mid + 1, right, target);
            } else {
                return check(arr, left, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        for (int i = -1; i < 9; i++) {
            System.out.println(i + " " + new SearchInRotatedSortedArray().search(arr, i));
        }

    }
}