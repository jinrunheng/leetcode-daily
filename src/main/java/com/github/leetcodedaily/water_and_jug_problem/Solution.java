package com.github.leetcodedaily.water_and_jug_problem;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * @Author Dooby Kim
 * @Date 2024/1/29 10:27 下午
 * @Version 1.0
 */
public class Solution {
    class Jug {

        public Jug(int jug1, int jug2) {
            this.jug1 = jug1;
            this.jug2 = jug2;
        }

        private int jug1;
        private int jug2;

        public int getJug1() {
            return jug1;
        }

        public void setJug1(int jug1) {
            this.jug1 = jug1;
        }

        public int getJug2() {
            return jug2;
        }

        public void setJug2(int jug2) {
            this.jug2 = jug2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Jug jug = (Jug) o;
            return jug1 == jug.jug1 &&
                    jug2 == jug.jug2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(jug1, jug2);
        }
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 1. 初始化一个 map，Map<Integer,Integer> map = new HashMap<>(); // key -> jug1Cur, value -> jug2Cur
        Set<Jug> set = new HashSet<>();
        Stack<Jug> stack = new Stack<>();
        stack.push(new Jug(0, 0));
        while (!stack.isEmpty()) {
            if (set.contains(stack.peek())) {
                stack.pop();
                continue;
            }
            set.add(stack.peek());
            final Jug pop = stack.pop();
            int remain1 = pop.getJug1();
            int remain2 = pop.getJug2();
            if (remain1 == targetCapacity || remain2 == targetCapacity || remain1 + remain2 == targetCapacity) {
                return true;
            }
            stack.push(new Jug(remain1, jug2Capacity));
            stack.push(new Jug(jug1Capacity, remain2));
            stack.push(new Jug(0, remain2));
            stack.push(new Jug(remain1, 0));
            stack.push(new Jug(remain1 - Math.min(remain1, jug2Capacity - remain2), remain2 + Math.min(remain1, jug2Capacity - remain2)));
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.push(new Jug(remain1 + Math.min(remain2, jug1Capacity - remain1), remain2 - Math.min(remain2, jug1Capacity - remain1)));
        }
        return false;
    }
}
