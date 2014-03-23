package com.leet.sort;

import com.leet.list.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author Allen
 * 
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		int i = 0;
		ListNode itr = head;
		ListNode mid = head;
		ListNode preMid = null;
		while (itr != null) {
			i++;
			itr = itr.next;
			if (i % 2 == 0) {
				preMid = mid;
				mid = mid.next;
			}
		}
		preMid.next = null;

		ListNode newHead = null;
		itr = null;
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(mid);

		while (left != null && right != null) {
			if (left.val <= right.val) {
				if (newHead == null) {
					itr = left;
					newHead = itr;
				} else {
					itr.next = left;
					itr = itr.next;
				}
				left = left.next;
			} else {
				if (newHead == null) {
					itr = right;
					newHead = itr;
				} else {

					itr.next = right;
					itr = itr.next;
				}
				right = right.next;
			}
			itr.next = null;
		}
		if (left != null) {
			if (newHead == null) {
				newHead = left;
			} else {
				itr.next = left;
			}
		}
		if (right != null) {
			if (newHead == null) {
				newHead = right;
			} else {
				itr.next = right;
			}
		}
		return newHead;
	}

	private ListNode quickSort(ListNode first, ListNode follow) {
		ListNode itr = follow;
		ListNode left = null;
		ListNode right = null;

		ListNode lh = null;
		ListNode rh = null;

		while (itr != null) {
			if (itr.val >= first.val) {
				if (rh == null) {
					rh = itr;
					right = itr;
				} else {
					right.next = itr;
					right = right.next;
				}
				itr = itr.next;
				right.next = null;
			} else {
				if (lh == null) {
					lh = itr;
					left = itr;
				} else {
					left.next = itr;
					left = left.next;
				}
				itr = itr.next;
				left.next = null;
			}
		}
		if (lh != null) {
			if (lh.next != null) {
				lh = quickSort(lh, lh.next);
			}
		}
		if (rh != null) {
			if (rh.next != null) {
				rh = quickSort(rh, rh.next);
			}
		}
		if (lh != null) {
			if (lh.next != null) {
				lh = quickSort(lh, lh.next);
			}
		}
		ListNode newHead = null;
		first.next = rh;
		if (lh != null) {
			newHead = lh;
			left.next = first;
		} else {
			newHead = first;
		}
		return newHead;
	}
}