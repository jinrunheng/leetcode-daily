package com.github.leetcodedaily.circle_and_rectangle_overlapping;

/**
 * @Author Dooby Kim
 * @Date 2023/6/25 10:36 上午
 * @Version 1.0
 */
public class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return checkInRect(radius, xCenter, yCenter, x1, y1, x2, y2)
                || checkUpRect(radius, xCenter, yCenter, x1, y1, x2, y2)
                || checkDownRect(radius, xCenter, yCenter, x1, y1, x2, y2)
                || checkLeftRect(radius, xCenter, yCenter, x1, y1, x2, y2)
                || checkRightRect(radius, xCenter, yCenter, x1, y1, x2, y2)
                || checkTopCorner(radius, xCenter, yCenter, x1, y1, x2, y2);
    }

    // 判断圆心是否在中心矩形中
    private boolean checkInRect(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return xCenter >= x1 && xCenter <= x2 && yCenter >= y1 && yCenter <= y2;
    }

    // 判断圆心是否在上部矩形中
    private boolean checkUpRect(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return xCenter >= x1 && xCenter <= x2 && yCenter >= y2 && yCenter <= y2 + radius;
    }

    // 判断圆心是否在下部矩形中
    private boolean checkDownRect(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return xCenter >= x1 && xCenter <= x2 && yCenter >= y1 - radius && yCenter <= y1;
    }

    // 判断圆心是否在左部矩形中
    private boolean checkLeftRect(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return xCenter >= x1 - radius && xCenter <= x1 && yCenter >= y1 && yCenter <= y2;
    }

    // 判断圆心是否在右部矩形中
    private boolean checkRightRect(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return xCenter >= x2 && xCenter <= x2 + radius && yCenter >= y1 && yCenter <= y2;
    }

    // 判断圆心是否在上下左右四个圆角中
    private boolean checkTopCorner(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        return (Math.pow(xCenter - x1, 2) + Math.pow(yCenter - y1, 2) <= radius * radius && xCenter >= x1 - radius && xCenter <= x1 && yCenter >= y1 - radius && yCenter <= y1)
                || (Math.pow(xCenter - x2, 2) + Math.pow(yCenter - y1, 2) <= radius * radius && xCenter >= x2 && xCenter <= x2 + radius && yCenter >= y1 - radius && yCenter <= y1)
                || (Math.pow(xCenter - x1, 2) + Math.pow(yCenter - y2, 2) <= radius * radius && xCenter >= x1 - radius && xCenter <= x1 && yCenter >= y2 && yCenter <= y2 + radius)
                || (Math.pow(xCenter - x2, 2) + Math.pow(yCenter - y2, 2) <= radius * radius && xCenter >= x2 && xCenter <= x2 + radius && yCenter >= y2 && yCenter <= y2 + radius);
    }

}
