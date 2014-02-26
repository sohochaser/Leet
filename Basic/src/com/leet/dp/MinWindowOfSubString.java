package com.leet.dp;

/**
 * <ol>
 * <li>Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 * <li>For example,
 * <li>S = "ADOBECODEBANC"
 * <li>T = "ABC"
 * <li>Minimum window is "BANC".
 * <li>Note:
 * <li>If there is no such window in S that covers all characters in T, return the empty string "".
 * <li>If there are multiple such windows, you are guaranteed that there will always be only one
 * unique minimum window in S.
 * </ol>
 * <p>
 * Created on Feb 20, 2014
 * 
 * @author Allen Yan
 */
public class MinWindowOfSubString {
    private static int MAX = Integer.MAX_VALUE;

    public String minWindow(String src, String t) {
        if (src == null || src.isEmpty() || t == null || t.isEmpty()) {
            return "";
        }
        int[][] memo = new int[src.length() + 1][t.length() + 1];
        for (int i = 0; i <= src.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                memo[i][j] = -1;
            }
        }
        MAX = src.length() + 1;
        check(src, t, memo, 0);
        int min = MAX;
        int k = 0;
        for (int i = 0; i <= src.length(); i++) {
            if (memo[i][t.length()] < min && memo[i][t.length()] >= 0) {
                min = memo[i][t.length()];
                k = i;
            }
        }
        if (min <= src.length()) {
            return src.substring(k, k + memo[k][t.length()]);
        }
        return "";
    }

    private int check(String src, String t, int[][] memo, int tail) {
        if (src.length() == 0 && t.length() != 0) {
            return MAX;
        } else if (src.length() == 0 && t.length() == 0) {
            return 0;
        }

        int sl = src.length() - 1;
        int tl = t.length() - 1;

        char sc = src.charAt(sl);
        char tc = t.charAt(tl);

        if (sc == tc) {
            if (memo[src.length()][t.length()] == -1) {
                memo[src.length()][t.length()] =
                    Math.min(1 + check(src.substring(0, sl), t.substring(0, tl), memo, tail > 1 ? tail + 1 : 1),
                        check(src.substring(0, sl), t, memo, 0));
            }
            System.out.println(src + " -> " + t + " : " + memo[src.length()][t.length()]);
            return memo[src.length()][t.length()];
        } else {
            if (memo[src.length() - 1][t.length()] == -1) {
                memo[src.length() - 1][t.length()] =
                    (tail > 0 ? tail + 1 : 0) + check(src.substring(0, sl), t, memo, (tail > 0 ? tail + 1 : 0));
            }
            System.out.println(src + " -> " + t + " : " + memo[src.length() - 1][t.length()]);
            return memo[src.length() - 1][t.length()];
        }
    }

    public static void main(String[] args) {
        String src = "ADOBECODEBANC";
        src = "BANK";
        String t = "ABC";
        System.out.println("result: " + new MinWindowOfSubString().minWindow(src, t));
    }
}