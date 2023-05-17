package com.github.leetcodedaily.determine_if_two_events_have_conflict;

/**
 * @Author Dooby Kim
 * @Date 2023/5/17 6:58 下午
 * @Version 1.0
 */
public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[0].compareTo(event2[1]) > 0 || event1[1].compareTo(event2[0]) < 0);
    }
}
