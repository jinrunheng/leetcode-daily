package com.github.leetcodedaily.largest_values_from_labels;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author Dooby Kim
 * @Date 2023/5/23 3:27 下午
 * @Version 1.0
 */
class V {
    private Integer value;
    private Integer label;

    public V(Integer value, Integer label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }
}

public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<V> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < values.length; i++) {
            maxHeap.add(new V(values[i], labels[i]));
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int i = 0;
        while (!maxHeap.isEmpty() && i < numWanted) {
            final V poll = maxHeap.poll();
            if (map.containsKey(poll.getLabel())) {
                if (map.get(poll.getLabel()) < useLimit) {
                    res += poll.getValue();
                    map.put(poll.getLabel(), map.get(poll.getLabel()) + 1);
                    i++;
                }
            } else {
                map.put(poll.getLabel(), 1);
                res += poll.getValue();
                i++;
            }
        }
        return res;
    }
}
