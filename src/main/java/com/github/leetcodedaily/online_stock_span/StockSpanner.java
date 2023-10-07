package com.github.leetcodedaily.online_stock_span;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Dooby Kim
 * @Date 2023/10/7 3:21 下午
 * @Version 1.0
 */
public class StockSpanner {
    class Stock {
        int price;

        int index;

        public Stock(int price, int index) {
            this.price = price;
            this.index = index;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    Deque<Stock> stack;
    int i;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.push(new Stock(Integer.MAX_VALUE, 0));
        i = 0;
    }

    public int next(int price) {
        // 100,80,60,70
        // 0,1,2,3

        // 60
        // 4
        i++;
        while (price >= stack.peek().getPrice()) {
            stack.pop();
        }
        int ret = i - stack.peek().getIndex();
        stack.push(new Stock(price, i));
        return ret;
    }
}
