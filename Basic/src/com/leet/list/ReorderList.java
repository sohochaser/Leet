package com.leet.list;

/**
 * <ol>
 * <li>Given a singly linked list L: L0��L1���Ln-1��Ln, reorder it to:
 * <li>L0��Ln��L1��Ln-1��L2��Ln-2��
 * <li>You must do this in-place without altering the nodes' values.
 * <li>For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * </ol>
 * 
 * @author Allen
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode left = null;
        ListNode right = null;

        ListNode itr = head;
        int n = 0;
        while (itr != null) {
            n++;
            itr = itr.next;
        }

        int leftEnd = n - (n / 2);
        itr = head;
        left = head;
        n = 0;
        while (itr != null) {
            n++;
            if (n == leftEnd) {
                right = itr.next;
                itr.next = null;
                break;
            }
            itr = itr.next;
        }
     
        itr = right;
        ListNode next;
        ListNode pre = null;
        while (itr != null) {
            next = itr.next;
            itr.next = pre;
            pre = itr;
            itr = next;
        }

        ListNode itr1 = null;
        while (left != null) {
            if (itr1 == null) {
                itr1 = left;
                itr = itr1;
            } else {
                itr1.next = left;
                itr1 = itr1.next;
            }
            left = left.next;

            if (pre != null) {
                itr1.next = pre;
                itr1 = itr1.next;
                pre = pre.next;
            }
        }
        head = itr;
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
        b.next=null;
        
        pList(a);
        new ReorderList().reorderList(a);
        pList(a);
    }

    public static void pList(final ListNode root) {
        System.out.println("\n-----------------------------------------------");
        ListNode head = root;
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }

    public void reorderListWrong(ListNode head) {
        ListNode root = head;

        ListNode left = null;
        ListNode right = null;

        ListNode oddList = null;
        ListNode eList = null;
        while (root != null) {
            if (oddList == null) {
                oddList = root;
                root = root.next;
                left = oddList;
            } else {
                oddList.next = root;
                root = root.next;
                oddList = oddList.next;
            }
            oddList.next = null;
            if (root != null) {
                if (eList == null) {
                    eList = root;
                    root = root.next;
                    right = eList;
                } else {
                    eList.next = root;
                    root = root.next;
                    eList = eList.next;
                }
                eList.next = null;
            } else {
                break;
            }
        }

        pList(left);
        pList(right);

        root = right;
        ListNode next;
        ListNode pre = null;
        while (root != null) {
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }

        ListNode itr = null;
        while (left != null) {
            if (itr == null) {
                itr = left;
                root = itr;
            } else {
                itr.next = left;
                itr = itr.next;
            }
            left = left.next;

            if (pre != null) {
                itr.next = pre;
                itr = itr.next;
                pre = pre.next;
            }
        }
        head = root;
    }
}