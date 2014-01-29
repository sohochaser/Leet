package com.leet.string;

/**
 * <ol>
 * <li>Given a string S and a string T, count the number of distinct subsequences of T in S.
 * <li>A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions of the
 * remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <li>Here is an example:
 * <li>S = "rabbbit", T = "rabbit"
 * <li>Return 3.
 * </ol>
 * <p>
 * Created on Jan 27, 2014
 * 
 * @author Allen Yan
 */
public class NumDistinct {
    public int numDistinct(String s, String t) {
        if (s.length() == 0) {
            return t.length() == 0 ? 1 : 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        int cnt = 0;
        char first = t.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first == c) {
                cnt += numDistinct(s.substring(i + 1), t.substring(1));
            }
        }
        return cnt;
    }

    public static void main(String[] args) {        
        System.out.println(new NumDistinct().numDistinct("rabbbit", "rabit"));
    }
}