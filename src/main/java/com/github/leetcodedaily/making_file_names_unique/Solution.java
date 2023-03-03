package com.github.leetcodedaily.making_file_names_unique;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2023/3/3 11:28 上午
 * @Version 1.0
 */
public class Solution {
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                map.put(names[i], 1);
                res[i] = names[i];
            } else {
                int startNum = map.get(names[i]);
                while (map.containsKey(names[i] + "(" + startNum + ")")) {
                    startNum++;
                }
                res[i] = names[i] + "(" + startNum + ")";
                map.put(names[i], map.get(names[i]) + 1);
                map.put(res[i], 1);
            }
        }
        return res;
    }
}
