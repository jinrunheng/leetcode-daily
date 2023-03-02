package com.github.leetcodedaily.bianry_number_to_string_lcci;

/**
 * @Author Dooby Kim
 * @Date 2023/3/2 7:37 下午
 * @Version 1.0
 */
public class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (sb.length() < 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }
        return num == 0 ? sb.toString() : "ERROR";
    }
}
