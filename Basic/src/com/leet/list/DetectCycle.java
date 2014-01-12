package com.leet.list;

public class DetectCycle {
	public ListNode detectCycle(ListNode head) {
		if (head != null && head.next != null) {
			if (head.next.next == head) {
				return head;
			}
		}
		ListNode slow = head;
		ListNode fast = head;

		ListNode firstNode = null;
		if (head != null) {
			slow = head;
			fast = head;

			while (slow.next != null && fast != null) {
				slow = slow.next;
				if (fast.next != null && fast.next.next != null) {
					fast = fast.next.next;
				} else {
					break;
				}
				if (slow == fast) {
					firstNode = slow;
					slow = head;
					break;
				}
			}
		}

		if (firstNode != null) {
			while (true) {
				slow = slow.next;
				fast = fast.next;
				if (slow == fast) {
					return slow;
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {

		ListNode a = new ListNode(3);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(0);
		ListNode d = new ListNode(-4);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = b;

		System.out.println(new DetectCycle().detectCycle(a));

		a = new ListNode(1);
		b = new ListNode(2);
		a.next = b;
		b.next = a;

		System.out.println(new DetectCycle().detectCycle(a));
	}
}