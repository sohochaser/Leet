package com.leet.list.merge;

import java.util.ArrayList;

import com.leet.list.ListNode;

public class MergeKLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }

        ListNode[] nodes = new ListNode[lists.size()];
        int total = 0;
        for (ListNode node : lists) {
            if (node != null) {
                nodes[total++] = node;
            }
        }
        MinHeap heap = new MinHeap(total);
        for (int i = 0; i < total; i++) {
            heap.add(nodes[i]);
        }
        ListNode newHead = null;
        ListNode currentNode = null;
        while (total > 0) {
            ListNode node = heap.removeMin();
            if (newHead == null) {
                newHead = node;
                currentNode = node;
            } else {
                currentNode.next = node;
                currentNode = currentNode.next;
            }

            ListNode next = node.next;
            if (next != null) {
                heap.add(next);
            } else {
                total--;
            }
            currentNode.next = null;
        }
        return newHead;
    }

    class MinHeap {
        int current;

        int size;

        ListNode[] arr;

        public MinHeap(int size) {
            this.current = 0;
            arr = new ListNode[size];
            this.size = size;
        }

        public boolean isEmpty() {
            return current == 0;
        }

        public boolean isFull() {
            return current == size;
        }

        public void add(ListNode node) {
            if (!isFull()) {
                arr[current] = node;
                filterUp(current);
                current++;
            }
        }

        public void filterUp(int start) {
            int c = start;
            int p = (c - 1) / 2;
            ListNode temp = arr[c];

            while (c > 0) {
                if (arr[p].val <= temp.val) {// greater than parent
                    break;
                } else {// smaller than parent
                    arr[c] = arr[p];
                    c = p;
                    p = (p - 1) / 2;
                }
                arr[c] = temp; //
            }
        }

        public ListNode removeMin() {
            if (isEmpty()) {
                return null;
            }
            ListNode root = arr[0];
            arr[0] = arr[current - 1];
            current--;
            filterDown(0, current - 1);
            return root;
        }

        public void filterDown(int start, int endOfHeap) {
            int parent = start;
            int child = 2 * parent + 1; // left child
            ListNode temp = arr[parent];

            while (child <= endOfHeap) { // end or not
                if (child < endOfHeap // Choose the smaller one
                    && arr[child].val > arr[child + 1].val) {
                    child++;
                }
                if (temp.val <= arr[child].val) { // done
                    break;
                } else { // smaller up, parent,child down
                    arr[parent] = arr[child];
                    parent = child;
                    child = 2 * child + 1;
                }
            }
            arr[parent] = temp;
        }
    }

    public static void main(String[] args) {
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);

        ListNode b = new ListNode(1);
        b.next = new ListNode(1);
        b.next.next = new ListNode(2);

        list.add(a);
        list.add(b);

        ListNode n = new MergeKLists().mergeKLists(list);
        ListNode.print(n);
    }
}