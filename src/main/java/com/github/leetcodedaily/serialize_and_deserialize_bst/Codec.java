package com.github.leetcodedaily.serialize_and_deserialize_bst;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dooby Kim
 * @Date 2023/9/4 10:22 下午
 * @Version 1.0
 * @Link https://leetcode.cn/problems/serialize-and-deserialize-bst
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 前序遍历
        StringBuilder sb = new StringBuilder("");
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        if (sb.length() != 0) sb.append(",");
        sb.append(node.val);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    //      4
    //    /   \
    //   3     7
    //  /     / \
    // 1     5   9
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        List<Integer> nums = new ArrayList<>();
        for(String s: data.split(",")) {
            nums.add(Integer.valueOf(s));
        }
        return buildTree(nums, 0, nums.size()-1);
    }

    private TreeNode buildTree(List<Integer>nums, int start, int end){
        if(start > end) return null;

        int val = nums.get(start);
        int mid = start + 1;
        while(mid <= end && nums.get(mid) < val) {
            mid++;
        }

        TreeNode node = new TreeNode(val);
        node.left = buildTree(nums, start + 1, mid - 1);
        node.right = buildTree(nums, mid, end);

        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(9);
        root.left = node1;
        node1.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;

        final String serialize = codec.serialize(root);
        System.out.println(serialize);

    }
}
