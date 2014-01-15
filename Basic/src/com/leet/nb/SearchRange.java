package com.leet.nb;

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
        if (left == right) {
            if (target == arr[left]) {
                return left;
            }
        } else {
            int mid = (left + right)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return check(arr, mid + 1, right, target);
            } else {
                return check(arr, left, mid - 1, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 7, 7, 8, 8, 10 };
        int[] result = new SearchRange().searchRange(arr, 8);
        for (int i : result) {
            System.out.println(i);
        }
    }
}