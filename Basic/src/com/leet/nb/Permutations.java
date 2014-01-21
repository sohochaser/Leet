package com.leet.nb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    // !!! Negative value like -1.
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        if (num.length == 1) {
            ArrayList<Integer> iList = new ArrayList<Integer>();
            iList.add(num[0]);
            result.add(iList);
            return result;
        }

        ArrayList<ArrayList<String>> tmp = new ArrayList<ArrayList<String>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < num.length; i++) {
            tmp.add(new ArrayList<String>());
            map.put("" + num[i], num[i]);
        }
        calculate(result, num, num.length - 1, tmp);
        ArrayList<String> p = tmp.get(num.length - 1);

        for (String s : p) {
            System.out.println(s);
            ArrayList<Integer> iList = new ArrayList<Integer>();
            for (int i = 0; i < s.length(); i++) {
                iList.add(map.get(String.valueOf(s.charAt(i))));
            }
            result.add(iList);
        }
        return result;
    }

    private void calculate(ArrayList<ArrayList<Integer>> result, int[] num, int pos, ArrayList<ArrayList<String>> tmp) {
        if (pos == 0) {
            ArrayList<String> cur = new ArrayList<String>();
            cur.add("" + num[0]);
            tmp.set(0, cur);
        } else {
            if (tmp.get(pos - 1).size() == 0) {
                calculate(result, num, pos - 1, tmp);
            }
            ArrayList<String> pre = tmp.get(pos - 1);
            ArrayList<String> cur = new ArrayList<String>();
            String single = String.valueOf(num[pos]);
            StringBuilder sb = new StringBuilder();
            for (String str : pre) {
                sb.setLength(0);
                for (int i = 0; i < str.length(); i++) {
                    sb.append(str.substring(0, i)).append(single).append(str.substring(i));
                    cur.add(sb.toString());
                    sb.setLength(0);
                }
                sb.append(str).append(single);
                cur.add(sb.toString());
            }
            tmp.set(pos, cur);
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
        int[] num = new int[] { 0, -1, 1 };
        ArrayList<ArrayList<Integer>> result = new Permutations().permute(num);
        for (ArrayList<Integer> r : result) {
            for (Integer i : r) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}