package com.leet.list.interval;

import java.util.ArrayList;

/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> list,
			Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (list == null || list.size() == 0) {
			if (newInterval != null) {
				result.add(newInterval);
				return result;
			}
		}
		if (newInterval == null) {
			return list;
		}

		int start = newInterval.start;
		int end = newInterval.end;

		int cnt = 0;
		int sIdx = -1;
		int eIdx = list.size();
		for (int i = 0, j = list.size() - 1; i <= j && cnt < 2;) {
			Interval iv = list.get(i);
			if (sIdx == -1) {
				if (start > iv.end) {
					i++;
				} else {
					sIdx = i;
					cnt++;
				}
			}
			if (eIdx == list.size()) {
				if (end < iv.start) {
					j--;
				} else {
					eIdx = j;
					cnt++;
				}
			}
		}

		if (sIdx == -1) {
			if (eIdx == list.size()) {

			}
		}
		return result;
	}
}