package cn.phorcys.algorithm;

import sun.jvm.hotspot.memory.HeapBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/29 下午4:41
 */
public class S49 {
    public int nthUglyNumber(int n) {
        Map<Integer, Integer> lastUse = new HashMap<>();
        lastUse.put(2, 0);
        lastUse.put(3, 0);
        lastUse.put(5, 0);
        int index = 1;
        int[] uglyArr = new int[n];
        uglyArr[0] = 1;
        while (index < n) {
            int value2 = uglyArr[lastUse.get(2)] * 2;
            int value3 = uglyArr[lastUse.get(3)] * 3;
            int value5 = uglyArr[lastUse.get(5)] * 5;
            int min = Math.min(value2, Math.min(value3, value5));
            uglyArr[index] = min;
            if (min == value2) lastUse.put(2, lastUse.get(2) + 1);
            if (min == value3) lastUse.put(3, lastUse.get(3) + 1);
            if (min == value5) lastUse.put(5, lastUse.get(5) + 1);
            index++;
        }
        return uglyArr[n - 1];
    }

    public int nthUglyNumber1(int n) {
        /*最小堆*/
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            int min = queue.poll();
            ugly = min;
            queue.offer(min * 2);
            queue.offer(min * 3);
            queue.offer(min * 5);
        }
        return ugly;
    }

    public static void main(String[] args) {
        new S49().nthUglyNumber(10);
    }
}
