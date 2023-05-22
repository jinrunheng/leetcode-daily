package com.github.leetcodedaily.insufficient_nodes_in_root_to_leaf_paths;

/**
 * @Author Dooby Kim
 * @Date 2023/5/22 2:21 下午
 * @Version 1.0
 */
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

public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        limit -= root.val;
        if (root.left == null && root.right == null) {
            return limit <= 0 ? root : null;
        }
        if (root.left != null) {
            root.left = sufficientSubset(root.left, limit);
        }
        if (root.right != null) {
            root.right = sufficientSubset(root.right, limit);
        }
        return root.right == null && root.left == null ? null : root;
    }
}
