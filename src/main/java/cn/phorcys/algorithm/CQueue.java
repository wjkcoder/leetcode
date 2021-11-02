package cn.phorcys.algorithm;

import java.util.Stack;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/27 下午5:38
 */
class CQueue {
    Stack<Integer> store;
    Stack<Integer> empty;

    public CQueue() {
        store = new Stack<>();
        empty = new Stack<>();
    }

    public void appendTail(int value) {
        store.push(value);
    }

    public int deleteHead() {
        if (store.isEmpty()) return -1;
        while (!store.isEmpty()) {
            Integer top = store.pop();
            empty.push(top);
        }
        Integer value = empty.pop();
        while (!empty.isEmpty()) {
            Integer top = empty.pop();
            store.push(top);
        }
        return value;
    }
}
