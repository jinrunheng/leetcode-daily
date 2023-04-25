package com.github.leetcodedaily.sort_the_people;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Dooby Kim
 * @Date 2023/4/25 7:33 下午
 * @Version 1.0
 */
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] res = new String[names.length];
        Map<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        Map<Integer, String> descOrderValueMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed()).forEachOrdered(e -> descOrderValueMap.put(e.getKey(), e.getValue()));

        Iterator<String> iterator = descOrderValueMap.values().iterator();
        int v = 0;
        while (iterator.hasNext()) {
            res[v++] = iterator.next();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        Solution solution = new Solution();
        final String[] strings = solution.sortPeople(names, heights);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
