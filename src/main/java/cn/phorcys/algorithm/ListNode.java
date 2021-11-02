package cn.phorcys.algorithm;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/28 上午11:01
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static ListNode createNode(int[] arr) {
        ListNode head = new ListNode(-1);
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(arr[i]);
            if (head.next != null) {
                node.next = head.next;
                head.next = node;
            }else {
                head.next = node;
            }
        }
        return head.next;
    }
}
