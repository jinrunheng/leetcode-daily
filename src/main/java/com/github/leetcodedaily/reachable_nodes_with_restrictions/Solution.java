package com.github.leetcodedaily.reachable_nodes_with_restrictions;

import java.util.*;

/**
 * @Author Dooby Kim
 * @Date 2024/3/2 下午8:03
 * @Version 1.0
 */
public class Solution {
    class UnionFind {
        public Map<Integer, Integer> map;
        public Map<Integer, Integer> size;

        public UnionFind(int n) {
            map = new HashMap<>();
            size = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i, i);
                size.put(i, 1);
            }
        }

        // 找到节点的头节点
        public int find(int i) {
            int root = map.get(i);
            if (i != root) {
                root = find(root);
            }
            map.put(i, root);
            return root;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                int pSize = size.get(pRoot);
                int qSize = size.get(qRoot);
                // 大的节点往小节点上合并
                if (pRoot > qRoot) {
                    map.put(pRoot,qRoot);
                    size.put(qRoot, pSize + qSize);
                }else {
                    map.put(qRoot, pRoot);
                    size.put(pRoot, qSize + pSize);
                }
            }
        }
    }


    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }
        UnionFind unionFind = new UnionFind(n);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int p = edges[i][0];
            int q = edges[i][1];
            if (!set.contains(p) && !set.contains(q)) {
                list.add(edges[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {

            int p = list.get(i)[0];
            int q = list.get(i)[1];
            unionFind.union(p, q);
            unionFind.union(q, p);
        }
        return unionFind.size.get(0);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{2, 1}, {1, 0}, {0, 3}};
        int[] restricted = {3, 2};
        Solution solution = new Solution();
        final int i = solution.reachableNodes(n, edges, restricted);
        System.out.println(i);
    }
}
