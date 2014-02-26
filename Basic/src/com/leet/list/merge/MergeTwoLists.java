package com.leet.list.merge;

import com.leet.list.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 * <p>
 * Created on Feb 26, 2014
 * 
 * @author Allen Yan
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;

        ListNode itr1 = l1;
        ListNode itr2 = l2;
        ListNode itr = null;
        while (itr1 != null && itr2 != null) {
            ListNode tmp = itr1;

            if (itr1.val < itr2.val) {
                tmp = itr1;
                itr1 = itr1.next;
            } else {
                tmp = itr2;
                itr2 = itr2.next;
            }

            if (itr == null) {
                itr = tmp;
                head = itr;
            } else {
                itr.next = tmp;
                itr = itr.next;
            }
            itr.next = null;
        }

        if (itr1 != null) {
            itr.next = itr1;
        } else if (itr2 != null) {
            itr.next = itr2;
        }
        return head;
    }
}