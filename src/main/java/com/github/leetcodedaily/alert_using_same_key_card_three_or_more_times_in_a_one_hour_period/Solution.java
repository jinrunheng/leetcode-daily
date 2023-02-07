package com.github.leetcodedaily.alert_using_same_key_card_three_or_more_times_in_a_one_hour_period;

import java.util.*;

/**
 * @Author Dooby Kim
 * @Date 2023/2/7 4:07 下午
 * @Version 1.0
 */
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            if (map.containsKey(keyName[i])) {
                List<String> list = map.get(keyName[i]);
                list.add(keyTime[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(keyTime[i]);
                map.put(keyName[i], list);
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (!check(entry.getValue())) {
                res.add(entry.getKey());
            }
        }

        res.sort((o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            int len = Math.min(len1, len2);
            for (int i = 0; i < len; i++) {
                if (o1.charAt(i) > o2.charAt(i)) {
                    return 1;
                } else if (o1.charAt(i) < o2.charAt(i)) {
                    return -1;
                }
            }
            return len1 - len2;
        });

        return res;
    }

    private boolean check(List<String> list) {
        int[] times = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(":");
            times[i] = Integer.parseInt(split[0] + split[1]);
        }
        Arrays.sort(times);

        for (int i = 0; i < times.length - 2; i++) {
            if (times[i + 2] - times[i] <= 100) {
                return false;
            }
        }
        return true;
    }
}