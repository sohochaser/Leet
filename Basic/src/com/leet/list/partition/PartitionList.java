package com.leet.list.partition;

import com.leet.list.ListNode;

/**
 * <ol>
 * <li>Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * <li>You should preserve the original relative order of the nodes in each of
 * the two partitions.
 * 
 * <li>For example,
 * <li>Given 1->4->3->2->5->2 and x = 3,
 * <li>return 1->2->2->4->3->5.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode left = null;
		ListNode right = null;
		ListNode itr = head;

		ListNode leftHead = null;
		ListNode rightHead = null;

		while (itr != null) {
			ListNode tmp = itr;
			itr = itr.next;
			tmp.next = null;
			if (tmp.val < x) {
				if (left == null) {
					left = tmp;
					leftHead = left;
				} else {
					left.next = tmp;
					left = left.next;
				}
			} else {
				if (right == null) {
					right = tmp;
					rightHead = right;
				} else {
					right.next = tmp;
					right = right.next;
				}
			}
		}

		if (leftHead != null) {
			head = leftHead;
			left.next = rightHead;
		} else {
			head = rightHead;
		}
		return head;
	}

	public static void main(String[] args) {
		// 1->4->3->2->5->2
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(2);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		
		ListNode l=new PartitionList().partition(null, 3);
		ListNode.print(l);
	}
}