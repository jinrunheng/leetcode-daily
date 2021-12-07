package com.github.leetcodedaily.coloring_a_border;

import java.util.ArrayList;
import java.util.List;

/**
 * 对联通分量的边界进行着色
 */
class Solution {
    private int r, c;
    private int[][] grid;
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private List<int[]> borders;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        r = grid.length;
        c = grid[0].length;
        this.grid = grid;
        visited = new boolean[r][c];
        borders = new ArrayList<>();

        visited[row][col] = true;
        dfs(row, col, grid[row][col]);
        for (int i = 0; i < borders.size(); i++) {
            int x = borders.get(i)[0];
            int y = borders.get(i)[1];
            grid[x][y] = color;
        }
        return grid;
    }

    private void dfs(int x, int y, int color) {
        boolean isBorder = false;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (!isValid(nextX, nextY) || grid[nextX][nextY] != color) {
                isBorder = true;
            } else if (!visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, color);
            }
        }
        if (isBorder) {
            borders.add(new int[]{x, y});
        }
    }


    private boolean isBorder(int x, int y) {

        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0];
            int nextY = y + dirs[d][1];
            if (!isValid(nextX, nextY) || grid[x][y] != grid[nextX][nextY])
                return true;
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
