package com.leet.list.sw;

import com.leet.list.ListNode;

/**
 * Swap Nodes in Pairs. Given a linked list, swap every two adjacent nodes and
 * return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author Allen
 * 
 */
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode sec = head.next;

		ListNode newHead = sec;

		ListNode pre = null;
		while (first != null && sec != null) {
			first.next = sec.next;
			sec.next = first;

			if (pre == null) {
				pre = first;
			} else {
				pre.next = sec;
				pre = first;// !!!!
			}

			first = first.next;
			if (first != null) {
				sec = first.next;
			} else {
				sec = null;
			}
		}

		return newHead;
	}

	public static void main(String[] args) {
		{
			ListNode a = new ListNode(1);
			ListNode b = new ListNode(2);
			ListNode c = new ListNode(3);
			ListNode d = new ListNode(4);

			a.next = b;
			b.next = c;
			c.next = d;

			// ListNode r = new SwapPairs().swapPairs(a);
			// ListNode.print(r);
		}

		// 2,5,3,4,6,2,2

		ListNode a = new ListNode(2);
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);

		ListNode e = new ListNode(6);
		ListNode f = new ListNode(2);
		ListNode g = new ListNode(2);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;

		ListNode r = new SwapPairs().swapPairs(a);
		ListNode.print(r);

	}
}