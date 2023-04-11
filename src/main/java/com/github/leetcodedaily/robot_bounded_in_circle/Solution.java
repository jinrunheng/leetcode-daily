package com.github.leetcodedaily.robot_bounded_in_circle;

/**
 * @Author Dooby Kim
 * @Date 2023/4/11 2:02 下午
 * @Version 1.0
 */
public class Solution {
    public static int x = 0;
    public static int y = 0;
    public static String direction = "N";

    public boolean isRobotBounded(String instructions) {

        // 总结，最多循环 4 次，如果循环 4 次，还没有回到原点，则返回 false
        String road = instructions + instructions + instructions + instructions;
        for (int i = 0; i < road.length(); i++) {
            char c = road.charAt(i);
            if (c == 'G') {
                go(direction);
            } else {
                changeDirection(c);
            }
        }

        return x == 0 && y == 0;
    }

    private void changeDirection(char c) {
        if (c == 'L') {
            if (direction.equals("N")) {
                direction = "W";
            } else if (direction.equals("W")) {
                direction = "S";
            } else if (direction.equals("S")) {
                direction = "E";
            } else if (direction.equals("E")) {
                direction = "N";
            }
        } else {
            if (direction.equals("N")) {
                direction = "E";
            } else if (direction.equals("E")) {
                direction = "S";
            } else if (direction.equals("S")) {
                direction = "W";
            } else if (direction.equals("W")) {
                direction = "N";
            }
        }
    }

    private void go(String direction) {
        if (direction.equals("N")) {
            y++;
        }
        if (direction.equals("E")) {
            x++;
        }
        if (direction.equals("S")) {
            y--;
        }
        if (direction.equals("W")) {
            x--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String instructions = "GLGLGGLGL";
        System.out.println(solution.isRobotBounded(instructions));
    }
}
