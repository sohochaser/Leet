package com.leet.list;

/**
 * <ol>
 * <li>
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to:
 * <li>L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * 
 * <li>You must do this in-place without altering the nodes' values.
 * 
 * <li>For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * </ol>
 * 
 * @author Allen
 * 
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		ListNode root = head;

		ListNode left = null;
		ListNode right = null;

		ListNode oddList = null;
		ListNode eList = null;
		while (root != null) {
			if (oddList == null) {
				oddList = root;
				left = oddList;
			} else {
				oddList.next = root;
				
			}
			if (root.next != null) {
				if (eList == null) {
					eList = root.next;
					right = eList;
				} else {
					eList.next = root.next;
											
				}				
			} else {
				break;
			}
			root = root.next.next;
			
		}
		
		pList(oddList);
		pList(eList);
		
		if (root != null && root != oddList) {
			oddList.next = root;
			oddList = oddList.next;
		}
		oddList.next = null;
		
		pList(oddList);
		pList(eList);
		
		root = right;
		ListNode next;
		ListNode pre = null;
		while (root != null) {
			next = root.next;
			root.next = pre;
			pre = root;

			root = next;
		}
		ListNode newHead = null;

		while (left != null && pre != null) {
			if (newHead == null) {
				newHead = left;
				root = newHead;
			} else {
				root.next = left;
				root = root.next;
			}
			left = left.next;

			root.next = pre;
			root = root.next;

			pre = pre.next;
		}
		if (left != null) {
			if (root == null) {
				root = left;
			} else {
				root.next = left;
			}
		}
		if (root != null) {
			root.next = null;
		}
		head = root;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		pList(a);
		new ReorderList().reorderList(a);
		pList(a);
	}

	public static void pList(ListNode root) {
		System.out
				.println("\n-----------------------------------------------\n");
		while (root != null) {
			System.out.print(root.val + "\t");
			root = root.next;
		}
	}
}