package com.leet.list;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "" + val + "->" + (next != null ? next.val : "null");
	}

	public static void print(ListNode head) {
		ListNode itr = head;
		while (itr != null) {
			System.out.print(itr + "\t");
			itr = itr.next;
		}
		System.out.println();
	}
}