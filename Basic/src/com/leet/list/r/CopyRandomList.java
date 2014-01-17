package com.leet.list.r;


/**
 * <ol>
 * <li>A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null.
 * <li>Return a deep copy of the list.
 * </ol>
 * <p>
 * Created on Jan 17, 2014
 * 
 * @author Allen Yan
 */
public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        RandomListNode itr = head;
        while (itr != null) {
            RandomListNode copy = new RandomListNode(itr.label);
            copy.next = itr.next;
            copy.random = itr.random;

            itr.next = copy;
            itr = copy.next;
        }

        itr = head;
        while (itr != null) {
            RandomListNode copy = itr.next;

            if (copy.random != null) {
                copy.random = copy.random.next;
            }
            itr = copy.next;
        }

        itr = head;
        RandomListNode root = null;
        RandomListNode newItr = null;
        while (itr != null) {
            RandomListNode old = itr;
            RandomListNode copy = itr.next;

            if (root == null) {
                root = copy;
                newItr = root;
            } else {
                newItr.next = copy;
                newItr = copy;//!!!!
            }
            old.next = copy.next;
            itr = copy.next;
        }
        return root;
    }
}