package com.github.leetcodedaily.alphabet_board_path;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2023/2/12 12:51 上午
 * @Version 1.0
 */
public class Solution {

    private Map<Character, int[]> initMap() {
        Map<Character, int[]> map = new HashMap<>();
        map.put('a', new int[]{0, 0});
        map.put('b', new int[]{0, 1});
        map.put('c', new int[]{0, 2});
        map.put('d', new int[]{0, 3});
        map.put('e', new int[]{0, 4});
        map.put('f', new int[]{1, 0});
        map.put('g', new int[]{1, 1});
        map.put('h', new int[]{1, 2});
        map.put('i', new int[]{1, 3});
        map.put('j', new int[]{1, 4});
        map.put('k', new int[]{2, 0});
        map.put('l', new int[]{2, 1});
        map.put('m', new int[]{2, 2});
        map.put('n', new int[]{2, 3});
        map.put('o', new int[]{2, 4});
        map.put('p', new int[]{3, 0});
        map.put('q', new int[]{3, 1});
        map.put('r', new int[]{3, 2});
        map.put('s', new int[]{3, 3});
        map.put('t', new int[]{3, 4});
        map.put('u', new int[]{4, 0});
        map.put('v', new int[]{4, 1});
        map.put('w', new int[]{4, 2});
        map.put('x', new int[]{4, 3});
        map.put('y', new int[]{4, 4});
        map.put('z', new int[]{5, 0});
        return map;
    }

    public String alphabetBoardPath(String target) {
        char from = 'a';
        String res = "";
        for (int i = 0; i < target.length(); i++) {
            res += getMinStepPath(from, target.charAt(i), initMap());
            from = target.charAt(i);
        }
        return res;
    }

    private String getMinStepPath(Character from, Character to, Map<Character, int[]> initMap) {
        int[] fromXY = initMap.get(from);
        int[] toXY = initMap.get(to);
        StringBuilder sb = new StringBuilder();

        if (fromXY[0] == 5) {
            moveUD(fromXY, toXY, sb);
            moveLR(fromXY, toXY, sb);
        } else {
            moveLR(fromXY, toXY, sb);
            moveUD(fromXY, toXY, sb);
        }


        sb.append("!");
        return sb.toString();
    }

    private void moveLR(int[] fromXY, int[] toXY, StringBuilder sb) {
        if (toXY[1] - fromXY[1] > 0) {
            int move = toXY[1] - fromXY[1];
            for (int i = 0; i < move; i++) {
                sb.append("R");
            }
        } else {
            int move = fromXY[1] - toXY[1];
            for (int i = 0; i < move; i++) {
                sb.append("L");
            }
        }
    }

    private void moveUD(int[] fromXY, int[] toXY, StringBuilder sb) {
        if (toXY[0] - fromXY[0] > 0) {
            int move = toXY[0] - fromXY[0];
            for (int i = 0; i < move; i++) {
                sb.append("D");
            }
        } else {
            int move = fromXY[0] - toXY[0];
            for (int i = 0; i < move; i++) {
                sb.append("U");
            }
        }
    }
}
