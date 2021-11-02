package cn.phorcys.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/27 下午7:11
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) return 0;
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.min();
        System.out.println(min);
        minStack.pop();
        minStack.top();
        min = minStack.min();
        System.out.println(min);
    }
}
