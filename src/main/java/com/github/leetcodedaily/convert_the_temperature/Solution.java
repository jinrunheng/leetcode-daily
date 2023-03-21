package com.github.leetcodedaily.convert_the_temperature;

/**
 * @Author Dooby Kim
 * @Date 2023/3/21 8:35 下午
 * @Version 1.0
 */
public class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
