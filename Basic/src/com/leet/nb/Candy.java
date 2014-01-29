package com.leet.nb;

/**
 * <ol>
 * <li>There are N children standing in a line. Each child is assigned a rating value.
 * <li>You are giving candies to these children subjected to the following requirements:
 * <li>Each child must have at least one candy.
 * <li>Children with a higher rating get more candies than their neighbors.
 * <li>What is the minimum candies you must give?
 * </ol>
 * <p>
 * Created on Jan 28, 2014
 * 
 * @author Allen Yan
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] dp = new int[ratings.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (dp[i - 1] <= dp[i]) {
                    dp[i - 1] = dp[i] + 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = new int[] { 2, 2, 1 };
        System.out.println(new Candy().candy(ratings));
    }
}