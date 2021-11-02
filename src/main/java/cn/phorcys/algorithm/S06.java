package cn.phorcys.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/28 上午11:02
 */
public class S06 {
    public int[] reversePrint(ListNode head) {
        /*栈*/
//        Stack<Integer> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head.val);
//            head = head.next;
//        }
//        List<Integer> values = new ArrayList<>();
//        while (!stack.isEmpty()) {
//            values.add(stack.pop());
//        }
//        return values.stream().mapToInt(Integer::intValue).toArray();
        /**/
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int[] values = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            values[i] = head.val;
            head = head.next;
        }
        return values;
    }

    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(-1);
        while (head != null) {
            ListNode node = new ListNode(head.val);
            if (p.next == null) {
                p.next = node;
            } else {
                node.next = p.next;
                p.next = node;
            }
            head = head.next;
        }
        return p.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.createNode(new int[]{1, 2, 3, 4, 5});
        new S06().reverseList(node);
    }
}
