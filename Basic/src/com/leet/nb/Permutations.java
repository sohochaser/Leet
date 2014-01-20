package com.leet.nb;

import java.util.ArrayList;

import com.leet.Notice;

/**
 * <ol>
 * <li>Given a collection of numbers, return all possible permutations.
 * <li>For example,
 * <li>[1,2,3] have the following permutations:
 * <li>[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * </ol>
 * <p>
 * Created on Jan 20, 2014
 * 
 * @author Allen Yan
 */
public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        } else if (num.length == 1) {
            ArrayList<Integer> pre = new ArrayList<Integer>();
            pre.add(num[0]);
            result.add(pre);
        } else if (num.length == 2) {
            ArrayList<Integer> pre = new ArrayList<Integer>();
            pre.add(num[0]);
            calculate(result, pre, num, 0);
            pre.clear();
            pre.add(num[1]);
            calculate(result, pre, num, 1);
        } else {
            ArrayList<Integer> pre = new ArrayList<Integer>();
            calculateR(result, pre, num, -1);
        }
        return result;
    }

    @Notice(desc = "Initial value.")
    private void calculate(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> pre, int[] num, int selected) {
        int[] flag = new int[num.length];
        ArrayList<Integer> r = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            flag[i] = i;
            r.add(num[i]);
        }
        result.add(r);
        while (true) {
            int[] mark = new int[num.length];
            for (int i = 0; i < num.length; i++) {
                mark[i] = 0;
            }
            r = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++) {
                if (mark[i] == 0) {
                    mark[i] = 1;
                    flag[i] = flag[i] + 1;
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permuteR(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        } else if (num.length == 1) {
            ArrayList<Integer> pre = new ArrayList<Integer>();
            pre.add(num[0]);
            result.add(pre);
        } else if (num.length == 2) {
            ArrayList<Integer> pre = new ArrayList<Integer>();
            pre.add(num[0]);
            calculateR(result, pre, num, 0);
            pre.clear();
            pre.add(num[1]);
            calculateR(result, pre, num, 1);
        } else {
            ArrayList<Integer> pre = new ArrayList<Integer>();
            calculateR(result, pre, num, -1);
        }
        return result;

    }

    @Notice(desc = "Initial value.")
    private void calculateR(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> pre, int[] remain, int selected) {
        if (remain.length == 2) {// !!!!!
            ArrayList<Integer> r = new ArrayList<Integer>();
            for (int i = 0; i < remain.length; i++) {
                if (i != selected) {
                    r.add(remain[i]);
                }
            }
            for (Integer i : pre) {
                r.add(i);
            }
            result.add(r);
        } else {
            int[] r;
            if (selected >= 0) {// !!!!! @Notice()
                r = new int[remain.length - 1];
            } else {
                r = new int[remain.length];
            }
            for (int i = 0, j = 0; i < remain.length;) {
                if (i != selected) {
                    r[j++] = remain[i++];
                } else {
                    i++;
                }
            }
            for (int i = 0; i < r.length; i++) {
                pre.add(r[i]);
                calculateR(result, pre, r, i);
                pre.remove(pre.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[] { 1, 2, 3, 4 };
        ArrayList<ArrayList<Integer>> result = new Permutations().permuteR(num);
        for (ArrayList<Integer> r : result) {
            for (Integer i : r) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}