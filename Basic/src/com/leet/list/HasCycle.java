package com.leet.list;

public class HasCycle {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		if (head != null) {
			slow = head;
			if (head.next != null) {
				fast = head.next.next;
			}

			while (slow.next != null&&fast!=null) {
				if (slow == fast) {
					return true;
				}
				slow = slow.next;

				if (fast.next != null && fast.next.next != null) {
					fast = fast.next.next;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = null;
		HasCycle h = new HasCycle();
		System.out.println(h.hasCycle(head));

		head = new ListNode(0);
		head.next = head;
		
		System.out.println(h.hasCycle(head));
		head = new ListNode(0);
		ListNode t=new ListNode(1);
		t.next=null;
		head.next=t;
		System.out.println(h.hasCycle(head));
	}

}
