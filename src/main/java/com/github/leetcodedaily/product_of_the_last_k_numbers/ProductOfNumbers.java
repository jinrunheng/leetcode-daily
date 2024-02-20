package com.github.leetcodedaily.product_of_the_last_k_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dooby Kim
 * @Date 2024/2/20 下午10:43
 * @Version 1.0
 */
public class ProductOfNumbers {
    List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
    }

    // 3,0,2,5,4
    // 2,10,40
    public void add(int num) {
        if (num == 0) {
            prefix.clear();
        } else {
            if (prefix.isEmpty()) {
                prefix.add(num);
            } else {
                prefix.add(num * prefix.get(prefix.size() - 1));
            }
        }
    }

    public int getProduct(int k) {
        int len = prefix.size();
        if (k > len) return 0;
        if (k == len) return prefix.get(len - 1);
        return prefix.get(len - 1) / prefix.get(len - 1 - k);
    }

}
