package com.leet.tree;

import com.leet.TreeLinkNode;
import com.leet.TreeNode;

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
public class PopulatingNextRightPointersII {

    public void connect1(TreeLinkNode root) {
        walk(root);
    }

    void walk(TreeLinkNode root) {
        while (root != null) {
            System.out.println(root);
            TreeLinkNode p = root;
            TreeLinkNode lastRight = null;
            while (p != null) {
                if (lastRight != null) {
                    if (p.left != null) {
                        lastRight.next = p.left;
                    } else {
                        lastRight.next = p.right;
                    }
                }
                if (p.left != null && p.right != null) {
                    p.left.next = p.right;
                    lastRight = p.right;
                } else if (p.left != null) {
                    lastRight = p.left;
                } else {
                    lastRight = p.right;
                }
                p = p.next;
            }
            while (root != null) {
                if (root.left != null) {
                    root = root.left;
                    break;
                } else if (root.right != null) {
                    root = root.right;
                    break;
                } else {
                    root = root.next;
                }
            }
        }
    }

    void connect(TreeLinkNode root) {
        TreeLinkNode node;
        if (root != null) {
            if (root.left != null) {
                root.left.next = root.right;
                if (root.left.next == null) {
                    node = root.next;
                    while (node != null && root.left.next == null) {
                        root.left.next = node.left;
                        if (root.left.next == null) {
                            root.left.next = node.right;
                        }
                        node = node.next;
                    }
                }
            }
            if (root.right != null) {
                node = root.next;
                while (node != null && root.right.next == null) {
                    root.right.next = node.left;
                    if (root.right.next == null) {
                        root.right.next = node.right;
                    }
                    node = node.next;
                }
            }
            connect(root.right);
            connect(root.left);
        }
    }

    /**
     * <ol>
     * <li>Input: {1,2,3,4,#,#,5}
     * <li>Output: {1,#,2,3,#,4,#}
     * <li>Expected: {1,#,2,3,#,4,5,#}
     * </ol>
     * 
     * @param parent
     */

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

    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;
        d.right = new TreeLinkNode(6);
        e.right = new TreeLinkNode(7);
        new PopulatingNextRightPointersII().connect1(a);
        System.out.println(a);
    }
}