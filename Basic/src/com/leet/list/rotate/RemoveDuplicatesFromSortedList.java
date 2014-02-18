package com.leet.list.rotate;

import com.leet.list.ListNode;

/**
 * <ol>
 * <li>Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <li>For example, Given 1->1->2, return 1->2.
 * <li>Given 1->1->2->3->3, return 1->2->3.
 * </ol>
 * <p>
 * Created on Feb 18, 2014
 * 
 * @author Allen Yan
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode itr = head.next;
        ListNode duplicate = null;
        while (itr != null) {
            if (itr.val != pre.val) {
                if (duplicate == null) {
                    pre = itr;
                } else {
                    pre.next = itr;
                    pre = itr;
                    duplicate = null;
                }
            } else {
                duplicate = itr;
            }
            itr = itr.next;
        }
        if (duplicate != null && duplicate.val == pre.val) {
            pre.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        new RemoveDuplicatesFromSortedList().deleteDuplicates(a);
        ListNode.print(a);
    }
}