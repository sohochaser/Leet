package com.leet.tree;

import java.util.ArrayList;
import java.util.Stack;

import com.leet.TreeNode;

/**
 * <ol>
 * <li>Given a binary tree, return the pre order traversal of its nodes' values.
 * <li>For example:
 * <li>Given binary tree {1,#,2,3}
 * <li>return [1,2,3].
 * <li>Note: Recursive solution is trivial, could you do it iteratively?
 * </ol>
 * <p>
 * Created on Jan 26, 2014
 * 
 * @author Allen Yan
 */
public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> result) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}