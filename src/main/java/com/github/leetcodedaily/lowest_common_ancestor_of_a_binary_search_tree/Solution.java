package com.github.leetcodedaily.lowest_common_ancestor_of_a_binary_search_tree;

/**
 * @Author Dooby Kim
 * @Date 2024/2/25 下午12:24
 * @Version 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p < root && q < root --> find in left
        // p > root && q > root --> find int right
        // else return root
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
