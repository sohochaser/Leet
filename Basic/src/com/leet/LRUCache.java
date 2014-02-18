package com.leet;

import java.util.HashMap;
import java.util.Map;

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

    Map<Integer, Pair> map = new HashMap<Integer, Pair>();

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
        Pair itr = map.get(key);

        if (itr != null) {
            v = itr.value;
            moveToHead(itr);
        }
        return v;
    }

    public void set(int key, int value) {
        if (current > 0) {
            Pair itr = map.get(key);
            if (itr != null) {
                itr.value = value;
                moveToHead(itr);
                return;
            }
        }

        Pair p = new Pair(key, value);
        map.put(key, p);
        if (current < capacity) {
            if (head == null) {
                head = p;
                tail = p;
            } else {
                p.next = head;
                head.pre = p;
                head = p;
            }
            current++;
        } else {

            p.next = head;
            head.pre = p;
            head = p;

            map.remove(tail.key);

            tail = tail.pre;
            tail.next = null;

        }
    }

    public void moveToHead(Pair itr) {
        if (itr.pre != null) {
            if (itr == tail) {
                tail = tail.pre;
            }

            Pair follow = itr.next;
            itr.pre.next = follow;
            if (follow != null) {
                follow.pre = itr.pre;
            }

            head.pre = itr;
            itr.next = head;

            head = itr;
            head.pre = null;
        }
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(1);
        c.set(2, 1);
        System.out.println(c.get(2));
        c.set(3, 2);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
    }
}
