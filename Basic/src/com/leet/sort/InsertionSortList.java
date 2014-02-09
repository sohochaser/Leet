package com.leet.sort;

import com.leet.list.ListNode;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Allen
 * 
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode min;
		ListNode minPre;

		ListNode newHead = null;
		ListNode sorted = null;

		ListNode itr = head;
		ListNode itrPre = head;

		ListNode remain = head;
		while (remain != null) {
			minPre = remain;
			min = remain;

			itrPre = remain;
			itr = remain.next;
			while (itr != null) {
				if (min.val > itr.val) {
					min = itr;
					minPre = itrPre;
				}
				itrPre = itr;
				itr = itr.next;
			}

			if (min == remain) {
				remain = remain.next;
			} else {
				minPre.next = min.next;
			}

			if (newHead == null) {
				newHead = min;
				sorted = min;
			} else {
				sorted.next = min;
				sorted = sorted.next;
			}
			min.next = null;
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);

		a.next = b;
		b.next = c;
		c.next = d;

		ListNode.print(a);

		System.out.println();
		ListNode itr = new InsertionSortList().insertionSortList(a);
		ListNode.print(itr);
	}
}
