package com.leet.string;

/**
 * <ol>
 * <li>Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <li>For example,
 * <li>Given:
 * <li>s1 = "aabcc",
 * <li>s2 = "dbbca",
 * <li>When s3 = "aadbbcbcac", return true.
 * <li>When s3 = "aadbbbaccc", return false.
 * </ol>
 * <p>
 * Created on Feb 19, 2014
 * 
 * @author Allen Yan
 */
public class DPIsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null) {
            return s3 == null || s3.length() == 0;
        } else if (s1 == null) {
            return s2.equals(s3);
        } else if (s2 == null) {
            return s1.equals(s3);
        } else if (s3 == null) {
            return false;
        }

        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }

        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return check(s1, s2, s3, memo);
    }

    private boolean check(String s1, String s2, String s3, int[][] memo) {
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        if (s3.length() == 0) {
            return false;
        }

        char c1 = s1.charAt(s1.length() - 1);
        char c2 = s2.charAt(s2.length() - 1);
        char c3 = s3.charAt(s3.length() - 1);

        String subS3 = s3.substring(0, s3.length() - 1);

        if (c1 != c2) {
            if (c1 == c3) {
                if (memo[s1.length() - 1][s2.length()] == -1) {
                    boolean result = check(s1.substring(0, s1.length() - 1), s2, subS3, memo);
                    memo[s1.length() - 1][s2.length()] = result ? 1 : 0;
                }
                return memo[s1.length() - 1][s2.length()] == 1;
            } else if (c2 == c3) {
                if (memo[s1.length()][s2.length() - 1] == -1) {
                    boolean result = check(s1, s2.substring(0, s2.length() - 1), subS3, memo);
                    memo[s1.length()][s2.length() - 1] = result ? 1 : 0;
                }
                return memo[s1.length()][s2.length() - 1] == 1;
            } else {
                return false;
            }
        } else {
            if (c1 == c3) {
                boolean first;
                boolean second;
                if (memo[s1.length() - 1][s2.length()] == -1) {
                    first = check(s1.substring(0, s1.length() - 1), s2, subS3, memo);
                    memo[s1.length() - 1][s2.length()] = first ? 1 : 0;
                }
                if (memo[s1.length()][s2.length() - 1] == -1) {
                    second = check(s1, s2.substring(0, s2.length() - 1), subS3, memo);
                    memo[s1.length()][s2.length() - 1] = second ? 1 : 0;
                }
                return (memo[s1.length() - 1][s2.length()] == 1) || memo[s1.length()][s2.length() - 1] == 1;
            } else {
                memo[s1.length()][s2.length()] = 0;
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";

        String s3 = "aadbbcbcac";
        s3 = "aadbbbaccc";
        System.out.println(new DPIsInterleave().isInterleave(s1, s2, s3));

        s1 = "aacaac";
        s2 = "aacaaeaac";
        s3 = "aacaaeaaeaacaac";
        System.out.println(new DPIsInterleave().isInterleave(s1, s2, s3));
    }
}