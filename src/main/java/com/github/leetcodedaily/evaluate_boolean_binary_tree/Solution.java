package com.github.leetcodedaily.evaluate_boolean_binary_tree;

/**
 * @Author Dooby Kim
 * @Date 2023/2/6 11:07 上午
 * @Version 1.0
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) return root.val == 1;
        else {
            if (root.val == 2) {
                return evaluateTree(root.left) || evaluateTree(root.right);
            } else {
                return evaluateTree(root.left) && evaluateTree(root.right);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}