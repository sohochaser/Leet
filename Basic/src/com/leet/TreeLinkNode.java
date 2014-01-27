package com.leet;

public class TreeLinkNode {
    int val;

    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
        val = x;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "TreeLinkNode [val=" + val + ", " + (left != null ? "left=" + left.val + ", " : "")
            + (right != null ? "right=" + right.val + ", " : "") + (next != null ? "next=" + next.val : "") + "]";
    }
}