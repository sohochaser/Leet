package com.leet.list;

/**
 * <ol>
 * <li>Given a list, rotate the list to the right by k places, where k is non-negative. For example:
 * <li>Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * </ol>
 * <p>
 * Created on Jan 14, 2014
 * 
 * @author Allen Yan
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int len = 0;
        ListNode itr = head;
        while (itr != null) {
            len++;
            itr = itr.next;
        }
        int k = n % len;

        int left = len - k;

        int i = 0;
        ListNode newhead = null;
        itr = head;
        while (itr != null) {
            i++;
            if (i == left) {
                newhead = itr.next;
                itr.next = null;
                break;
            }
            itr = itr.next;
        }
        if (newhead == null) {
            return head;
        }
        itr = newhead;
        while (itr.next != null) {
            itr = itr.next;
        }
        while (head != null) {
            itr.next = head;
            head = head.next;
            itr = itr.next;
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.next=null;

        p(a);
        p(new RotateRight().rotateRight(a, 2));
    }

    public static void p(ListNode head) {
        ListNode itr = head;
        while (itr != null) {
            System.out.print(itr.val + "\t");
            itr = itr.next;
        }
        System.out.println();
    }
}