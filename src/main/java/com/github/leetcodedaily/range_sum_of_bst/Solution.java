package com.github.leetcodedaily.range_sum_of_bst;

/**
 * @Author Dooby Kim
 * @Date 2024/2/26 上午12:30
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = rangeSumBST(root.left, low, high);
        }
        if (root.right != null) {
            right = rangeSumBST(root.right, low, high);
        }
        return root.val >= low && root.val <= high ? root.val + left + right : left + right;
    }
}
