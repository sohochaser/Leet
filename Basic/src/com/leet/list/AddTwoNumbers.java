package com.leet.list;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode newHead = null;
		ListNode itr = null;
		int plus = 0;
		int sum = 0;

		ListNode a = l1;
		ListNode b = l2;
		while (a != null && b != null) {
			sum = a.val + b.val + plus;
			if (sum > 9) {
				sum = sum % 10;
				plus = 1;
			} else {
				plus = 0;
			}
			ListNode l = new ListNode(sum);
			if (newHead == null) {
				newHead = l;
				itr = newHead;
			} else {
				itr.next = l;
				itr = itr.next;
			}
			a=a.next;
			b=b.next;
		}
		ListNode remain = null;
		if (a != null) {
			remain = a;
		} else {
			remain = b;

		}
		while (remain != null) {
			sum = remain.val + plus;
			if (sum > 9) {
				sum = sum % 10;
				plus = 1;
			} else {
				plus = 0;
			}
			ListNode l = new ListNode(sum);
			if (newHead == null) {
				newHead = l;
				itr = newHead;
			} else {
				itr.next = l;
				itr = itr.next;
			}
			remain=remain.next;
		}
		if(plus==1){
			ListNode l = new ListNode(1);
			itr.next = l;
		}
		return newHead;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		a.next = b;
		b.next = c;

		ListNode aa = new ListNode(5);
		ListNode bb = new ListNode(6);
		ListNode cc = new ListNode(7);
		aa.next = bb;
		bb.next = cc;

		ListNode r = new AddTwoNumbers().addTwoNumbers(a, aa);
		while (r != null) {
			System.out.println(r.val);
			r = r.next;
		}
	}
}
