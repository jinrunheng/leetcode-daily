package com.github.leetcodedaily.merge_in_between_linked_lists;

/**
 * @Author Dooby Kim
 * @Date 2023/1/30 10:58 上午
 * @Version 1.0
 */
public class Solution {

    /**
     * list[a - 1] = head1
     * list[a] = removeHead
     * list[b] = removeTail
     * list[b + 1] = head2
     * <p>
     * 1. 找到 list1[a - 1]
     * 2. 找到 list1[b + 1]
     * 3. list1[a - 1].next = list2.head；list1[b].next = null
     * 4. list2.tail.next = list1[b + 1]
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode head1 = null;
        ListNode head2 = null;
        ListNode removeHead = null;
        ListNode removeTail = null;

        ListNode cur = list1;
        int i = 0;
        while (cur != null) {
            if (i == a - 1) {
                head1 = cur;
            }
            if (i == a) {
                removeHead = cur;
            }
            if (i == b) {
                removeTail = cur;
            }
            if (i == b + 1) {
                head2 = cur;
            }
            cur = cur.next;
            i++;
        }
        head1.next = list2;
        removeTail.next = null;

        cur = list2;
        ListNode list2Tail = null;
        while (cur != null) {
            if (cur.next == null) {
                list2Tail = cur;
            }
            cur = cur.next;
        }
        list2Tail.next = head2;

        return list1;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
