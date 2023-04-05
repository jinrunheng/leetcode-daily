package com.github.leetcodedaily.number_of_common_factors;

/**
 * @Author Dooby Kim
 * @Date 2023/4/5 3:08 下午
 * @Version 1.0
 */
public class Solution {
    public int commonFactors(int a, int b) {
        int res = 0;
        int gcd = gcd(a, b);
        // 获取 gcd 的所有因数
        int i = 1;
        while (i * i <= gcd) {
            if (gcd % i == 0 && i * i != gcd) {
                res += 2;
            } else if (gcd % i == 0 && i * i == gcd) {
                res++;
            }
            i++;
        }
        return res;
    }

    public static int gcd(int num1, int num2) {
        int res = num2;
        while (num1 % num2 != 0) {
            res = num1 % num2;
            num1 = num2;
            num2 = res;
        }

        return res;
    }
}
