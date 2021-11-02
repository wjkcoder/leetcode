package cn.phorcys.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Wonder
 * @Date: Created on 2021/11/2 上午11:20
 */
public class S32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int val = node.val;
            values.add(val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return values.stream().mapToInt(Integer::intValue).toArray();
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> valueList = new ArrayList<>();
        /*使用两个队列*/
        while (!queue.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            valueList.add(values);
            Queue<TreeNode> cQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                values.add(p.val);
                if (p.left != null) cQueue.offer(p.left);
                if (p.right != null) cQueue.offer(p.right);
            }
            queue = cQueue;
        }
        return valueList;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> valueList = new ArrayList<>();
        /*使用两个队列*/
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> values = new LinkedList<>();
            valueList.add(values);
            Queue<TreeNode> cQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                if (level % 2 == 1) {
                    values.addFirst(p.val);
                } else {
                    values.add(p.val);
                }
                if (p.left != null) cQueue.offer(p.left);
                if (p.right != null) cQueue.offer(p.right);
            }
            queue = cQueue;
            level++;
        }
        return valueList;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 9, 20, null, null, 15, 7);
        Integer[] array = (Integer[]) arr.toArray();
        TreeNode node = BinaryTreeTraverse.getTreeFromArray(array);
        new S32().levelOrder2(node);
    }
}
