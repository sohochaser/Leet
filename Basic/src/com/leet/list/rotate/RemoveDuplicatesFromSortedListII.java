package com.leet.list.rotate;

import com.leet.list.ListNode;

/**
 * <ol>
 * <li>Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only
 * distinct numbers from the original list.
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

        ListNode pre = head;
        ListNode itr = head.next;
        ListNode newhead = null;
        ListNode ni = null;
        boolean exist = false;
        while (itr != null) {
            if (itr.val != pre.val && !exist) {
                if (newhead == null) {
                    newhead = pre;
                    ni = newhead;

                } else {
                    ni.next = pre;
                    ni = ni.next;
                }
                ni.next = null;
            } else {
                if (itr.val == pre.val) {
                    exist = true;
                } else {
                    exist = false;
                    pre = itr;
                }
            }
            itr = itr.next;
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        new RemoveDuplicatesFromSortedListII().deleteDuplicates(a);
        ListNode.print(a);
    }
}