package com.github.leetcodedaily.binary_tree_coloring_game;

/**
 * @Author Dooby Kim
 * @Date 2023/2/3 10:49 上午
 * @Version 1.0
 */
public class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findX(root, x);
        int size = n;
        int xNodeLeftTreeSize = getTreeSize(xNode.left, 0);
        int xNodeRightTreeSize = getTreeSize(xNode.right, 0);
        int other = size - 1 - xNodeLeftTreeSize - xNodeRightTreeSize;
        return other > size / 2 || xNodeLeftTreeSize > size / 2 || xNodeRightTreeSize > size / 2;
    }

    private int getTreeSize(TreeNode node, int size) {
        if (node == null) {
            return size;
        } else {
            size += 1 + getTreeSize(node.left, size) + getTreeSize(node.right, size);
        }
        return size;
    }

    private TreeNode findX(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        } else {
            return findX(node.left, x) != null ? findX(node.left, x) : findX(node.right, x);
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