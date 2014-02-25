package com.leet.list.sw;

import java.util.ArrayList;

import com.leet.list.ListNode;

public class MergeKLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		if (lists.size() == 1) {
			return lists.get(0);
		}

		int[] memo = new int[lists.size()];
		ListNode[] nodes = new ListNode[lists.size()];
		
		return null;
	}
}