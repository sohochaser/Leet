package com.leet.dict;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (char) (i + 1 + '0');
        }
        if (n == 1 && k > 1) {
            return "";
        } else if (n == 1 && k == 1) {
            return "1";
        }

        int levelNodes = 1;
        for (int i = 1; i <= n; i++) {
            levelNodes *= i;
        }
        if (k > levelNodes) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int remain = n;
        while (true) {
            if (levelNodes == 2) {
                break;
            }
            levelNodes = levelNodes / remain;
            int idx = k / levelNodes;
            if (k == levelNodes) {
                idx = 0;
            }
            sb.append(getChar(arr, idx));
            k = k - idx * levelNodes;
            remain--;
        }
        if (k == 1) {
            sb.append(getChar(arr, 0));
            sb.append(getChar(arr, 0));
        } else {
            sb.append(getChar(arr, 1));
            sb.append(getChar(arr, 0));
        }
        return sb.toString();
    }

    public char getChar(char[] arr, int idx) {
        char rtn = ' ';
        int k = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                continue;
            }
            k++;
            if (k == idx) {
                rtn = arr[i];
                arr[i] = '0';
                return rtn;
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        GetPermutation g = new GetPermutation();
        System.out.println(g.getPermutation(3, 4));
    }
}