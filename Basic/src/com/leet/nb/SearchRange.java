package com.leet.nb;

/**
 * <ol>
 * <li>Given a sorted array of integers, find the starting and ending position of a given target
 * value.
 * <li>Your algorithm's runtime complexity must be in the order of O(log n).
 * <li>If the target is not found in the array, return [-1, -1].
 * <li>For example,
 * <li>Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * </ol>
 * <h2>Check the boundary(left,right <=0);
 * <p>
 * Created on Jan 15, 2014
 * 
 * @author Allen Yan
 */
public class SearchRange {
    public int[] searchRange(int[] arr, int target) {
        int[] result = new int[] { -1, -1 };

        if (arr != null && arr.length > 0) {
            int idx = check(arr, 0, arr.length - 1, target);
            if (idx != -1) {
                result[0] = idx;
                for (int i = idx - 1; i >= 0; i--) {
                    if (arr[i] == target) {
                        result[0] = i;
                    }
                }

                result[1] = idx;
                for (int i = idx + 1; i < arr.length; i++) {
                    if (arr[i] == target) {
                        result[1] = i;
                    }
                }
                return result;
            }
        }
        return result;

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
        int[] arr = new int[] { 2,5,7 };
        int[] result = new SearchRange().searchRange(arr, 4);
        for (int i : result) {
            System.out.println(i);
        }
    }
}