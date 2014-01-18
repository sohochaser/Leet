package com.leet.list;

/**
 * <ol>
 * <li>Sort a linked list in O(n log n) time using constant space complexity.
 * </ol>
 * <p>
 * Created on Jan 13, 2014
 * 
 * @author Allen Yan
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode first = head;
		ListNode left = first.next;
		ListNode right = first.next;
		while (left != right) {

		}
		return head;
	}

	private void check(ListNode left, ListNode right) {
		if (left == right) {
			return;
		}
		ListNode first = left.next;

	}
}