package com.leet.tree;

import com.leet.TreeLinkNode;

/**
 * Populating Next Right Pointers in Each Node Definition for binary tree with next pointer. public
 * class TreeLinkNode { int val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; } }
 * <ol>
 * <li>populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * <li>initially, all next pointers are set to NULL.
 * </ol>
 * <ol>
 * <li>Note:
 * <li>You may only use constant extra space.
 * <li>You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and
 * every parent has two children).
 * </ol>
 */
public class PopulatingNextRightPointers {
    public void connect(TreeLinkNode root) {
        walk(root);
    }

    private void walk(TreeLinkNode parent) {
        if (parent != null) {
            TreeLinkNode p = parent;
            TreeLinkNode lastRight = null;
            while (p != null && p.left != null) {
                if (lastRight != null) {
                    lastRight.next = p.left;
                }
                p.left.next = p.right;
                lastRight = p.right;
                p = p.next;
            }
            walk(parent.left);
        }
    }

    void walk1(TreeLinkNode parent) {
        while (parent != null) {
            TreeLinkNode p = parent;
            TreeLinkNode lastRight = null;
            while (p != null && p.left != null) {
                if (lastRight != null) {
                    lastRight.next = p.left;
                }
                p.left.next = p.right;
                lastRight = p.right;
                p = p.next;
            }
            parent = parent.left;
        }
    }
}