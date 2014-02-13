package com.leet.design;

/**
 * <ol>
 * <li>Design and implement a data structure for Least Recently Used (LRU) cache. It should support
 * the following operations: get and set.
 * <li>get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * <li>set(key, value) - Set or insert the value if the key is not already present. When the cache
 * reached its capacity, it should invalidate the least recently used item before inserting a new
 * item.
 * </ol>
 * <p>
 * Created on Feb 13, 2014
 * 
 * @author Allen Yan
 */
public class LRUCache {

    int current;

    final int capacity;

    Pair head;

    Pair tail;

    static class Pair {
        int key;

        int value;

        Pair next;

        Pair pre;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
            pre = null;
        }

        /** {@inheritDoc} */
        @Override
        public String toString() {
            return "Pair [key=" + key + ", value=" + value + ", next=" + next.value + "]";
        }

    }

    public LRUCache(int capacity) {

        this.capacity = capacity;
        current = 0;
    }

    public int get(int key) {
        int v = -1;
        if (current == 0) {
            return v;
        }
        Pair itr = head;
        while (itr != null) {
            if (itr.key == key) {
                break;
            }
            itr = itr.next;
        }

        if (itr != null) {
            v = itr.value;
            if (itr.pre != null) {
                itr.pre.next = itr.next;
                if (itr.next != null) {
                    itr.next.pre = itr.pre;
                }

                itr.next = head;
                head.pre = itr;
                itr.pre = null;
                head = itr;
            }
        }
        return v;
    }

    public void set(int key, int value) {
        if (current > 0) {
            Pair itr = head;
            while (itr != null) {
                if (itr.key == key) {
                    break;
                }
                itr = itr.next;
            }

            if (itr != null) {
                itr.value = value;
                if (itr.pre != null) {
                    itr.pre.next = itr.next;
                    if (itr.next != null) {
                        itr.next.pre = itr.pre;
                    }

                    itr.next = head;
                    head.pre = itr;
                    itr.pre = null;
                    head = itr;
                }
                return;
            }
        }

        Pair p = new Pair(key, value);
        if (current < capacity) {
            if (head == null) {
                head = p;
                tail = p;
            } else {
                p.next = head;
                if (tail.pre == null) {
                    tail.pre = head;
                }
                head = p;
            }
            current++;
        } else {
            if (tail == head) {
                head = p;
                tail = p;
            } else {
                tail.pre = tail.pre.pre;
                tail = tail.pre;
                tail.next = null;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);

        c.set(2, 1);
        c.set(1, 1);
        System.out.println(c.get(2));
        c.set(4, 1);
        System.out.println(c.get(1));
        System.out.println(c.get(2));
    }
}
