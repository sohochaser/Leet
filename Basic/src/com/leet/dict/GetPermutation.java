package com.leet.dict;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (char) (i + 1 + '0');
        }
        int max = 1;
        for (int i = 1; i <= n; i++) {
            max *= i;
        }
        if (k > max) {
            return "";
        }
        int levelNodes = max;
        StringBuilder sb = new StringBuilder();
        int remain = n;

        while (true) {
            if (remain == 1) {
                break;
            }
            levelNodes = levelNodes / remain;
            int idx = 0;
            for (int i = 1; i <= remain; i++) {
                int tmp = i * levelNodes;
                if (k <= tmp) {
                    idx = i - 1;
                    break;
                }
            }
            sb.append(getChar(arr, idx));
            k = k - idx * levelNodes;
            remain--;
        }
        sb.append(getChar(arr, 0));
        return sb.toString();
    }

    public char getChar(char[] arr, int idx) {
        char rtn = ' ';
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                continue;
            }

            if (k == idx) {
                rtn = arr[i];
                arr[i] = '0';
                return rtn;
            }
            k++;
        }
        return rtn;
    }

    public static void main(String[] args) {
        GetPermutation g = new GetPermutation();
        System.out.println(g.getPermutation(5, 1));
    }
}