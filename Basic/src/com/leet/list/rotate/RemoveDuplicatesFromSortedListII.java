package com.leet.list.rotate;

import com.leet.list.ListNode;

/**
 * <ol>
 * <li>Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <li>For example,
 * <li>Given 1->2->3->3->4->4->5, return 1->2->5.
 * <li>Given 1->1->1->2->3, return 2->3.
 * </ol>
 * <p>
 * Created on Feb 18, 2014
 * 
 * @author Allen Yan
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode h = null;
		ListNode itr = null;
		ListNode pre = head;
		int preNB = 1;
		ListNode mid = head.next;
		while (mid != null) {
			if (mid.val == pre.val) {
				preNB++;
			} else {
				if (preNB == 1) {
					if (h == null) {
						h = pre;
						itr = h;
					} else {
						itr.next = pre;
						itr = itr.next;
					}					
				} else {					
					preNB = 1;
				}
			}
			pre = mid;
			mid = mid.next;
			if(itr!=null){
				itr.next = null;
			}
		}

		if (pre != null && preNB == 1) {
			if(h==null){
				h=pre;
				itr=h;
			}else{
				itr.next=pre;
				itr=itr.next;
			}						
			itr.next = null;
		}
		return h;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(3);

		a.next = b;
		b.next = c;

		ListNode h = new RemoveDuplicatesFromSortedListII().deleteDuplicates(a);
		ListNode.print(h);
	}
}