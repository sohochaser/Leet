package com.leet.list;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "" + val +"->"+ (next!=null?next.val:"null");
	}
}