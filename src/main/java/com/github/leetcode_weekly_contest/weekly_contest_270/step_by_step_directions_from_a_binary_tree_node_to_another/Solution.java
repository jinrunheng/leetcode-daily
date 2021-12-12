package com.github.leetcode_weekly_contest.weekly_contest_270.step_by_step_directions_from_a_binary_tree_node_to_another;

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

class Solution {

    private String path = "";

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, new StringBuilder());
        String pathToStart = path;
        path = "";
        dfs(root, destValue, new StringBuilder());
        String pathToDest = path;
        StringBuilder resBuilder = new StringBuilder();


        int i = 0;
        while (i < pathToStart.length()
                && i < pathToDest.length()
                && pathToStart.charAt(i) == pathToDest.charAt(i)) {
            i++;
        }

        String path1 = pathToStart.substring(i, pathToStart.length())
                .replaceAll("L", "U")
                .replaceAll("R", "U");
        String path2 = pathToDest.substring(i, pathToDest.length());
        return path1 + path2;
    }

    private boolean dfs(TreeNode root, int value, StringBuilder sb) {
        if (root != null && root.val == value) {
            path = sb.toString();
            return true;
        }

        if (root != null && root.left != null) {
            sb.append("L");
            if (dfs(root.left, value, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);
        }

        if (root != null && root.right != null) {
            sb.append("R");
            if (dfs(root.right, value, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }
}
