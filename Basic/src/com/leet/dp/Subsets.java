package com.leet.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <ol>
 * <li>Given a set of distinct integers, S, return all possible subsets.
 * <li>Note:
 * <li>Elements in a subset must be in non-descending order.
 * <li>The solution set must not contain duplicate subsets.
 * <li>For example,
 * <li>If S = [1,2,3], a solution is: <
 * </ol>
 * <code>
 * [
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
 ]
 * </code>
 * 
 * @author Allen
 * 
 */
public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] s) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (s == null || s.length == 0) {
			result.add(new ArrayList<Integer>());
			return result;
		}

		Arrays.sort(s);

		ArrayList<ArrayList<ArrayList<Integer>>> tmp = new ArrayList<ArrayList<ArrayList<Integer>>>();
		for (int i = 0; i <= s.length; i++) {
			tmp.add(new ArrayList<ArrayList<Integer>>());
		}

		check(s, -1, tmp);
		for (int i = 0; i <= s.length; i++) {
			check(s, i, tmp);
		}

		return tmp.get(s.length);
	}

	private void check(int[] s, int idx,
			ArrayList<ArrayList<ArrayList<Integer>>> tmp) {
		if (idx == s.length) {
			return;
		}
		if (idx == -1) {
			tmp.get(idx + 1).add(new ArrayList<Integer>());
		} else {
			ArrayList<ArrayList<Integer>> pre = tmp.get(idx);
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
			int v = s[idx];
			for (ArrayList<Integer> list : pre) {
				ArrayList<Integer> dest = new ArrayList<Integer>();
				for (Integer i : list) {
					dest.add(i);
				}
				current.add(dest);

				dest = new ArrayList<Integer>();
				for (Integer i : list) {
					dest.add(i);
				}
				dest.add(v);
				current.add(dest);
			}
			tmp.set(idx + 1, current);
		}
	}

	public static void main(String[] args) {
		int[] s = new int[] { 2, 1, 3 };
		ArrayList<ArrayList<Integer>> a = new Subsets().subsets(s);
		for (ArrayList<Integer> l : a) {
			System.out.println(l);
		}
	}
}