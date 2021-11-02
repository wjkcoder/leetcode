package cn.phorcys.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Wonder
 * @Date: Created on 2021/10/21 上午10:19
 */
public class BinaryTreeTraverse {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 3, null, 7, 1, 10);
        System.out.println("二叉树元数据");
        System.out.println(arr);
        Integer[] array = (Integer[]) arr.toArray();
        TreeNode node = BinaryTreeTraverse.getTreeFromArray(array);
        List<Integer> levelResult = BinaryTreeTraverse.levelTraverse(node);
        System.out.println("层次遍历结果");
        BinaryTreeTraverse.print(levelResult);
        List<Integer> preOrderTraverse = BinaryTreeTraverse.preOrderTraverse(node);
        System.out.println("前序遍历结果");
        BinaryTreeTraverse.print(preOrderTraverse);
        System.out.println("中序遍历结果");
        List<Integer> inorderTraverse = BinaryTreeTraverse.inorderTraverse(node);
        BinaryTreeTraverse.print(inorderTraverse);
    }

    public static void print(List<Integer> arr) {
        System.out.println(arr);
    }

    /*层次遍历初始化树*/
    public static TreeNode getTreeFromArray(Integer[] arr) {
        if (arr.length <= 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        int i = 0;
        while (i < arr.length) {
            TreeNode node = queue.poll();
            if (node == null) {
                root = new TreeNode(arr[i]);
                queue.offer(root);
                i++;
                continue;
            }
            if (i == arr.length - 1) {
                TreeNode left = new TreeNode(arr[i]);
                node.left = left;
                break;
            } else {
                if (arr[i] != null) {
                    TreeNode left = new TreeNode(arr[i]);
                    node.left = left;
                    queue.offer(left);
                }
                if (arr[i + 1] != null) {
                    TreeNode right = new TreeNode(arr[i + 1]);
                    node.right = right;
                    queue.offer(right);
                }
                i += 2;
            }
        }
        return root;
    }

    /*层次遍历*/
    public static List<Integer> levelTraverse(TreeNode root) {
        if (root == null) return new ArrayList<>();
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
        return values;
    }

    /*前序遍历 父-左-右*/
    public static List<Integer> preOrderTraverse(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> values = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int val = node.val;
            values.add(val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return values;
    }

    /*中序遍历非递归 左-父-右*/
    private static List<Integer> inorderTraverse(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> values = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                values.add(cur.val);
                cur = cur.right;
                if (cur != null) stack.push(cur);
            }
            if (cur == null) continue;
            cur = cur.left;
            if (cur != null) {
                stack.push(cur);
            }
        }
        return values;
    }

    /*后序遍历递归 左-右-父*/
    private static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (root.left != null) result.addAll(postOrderTraversal(root.left));
        if (root.right != null) result.addAll(postOrderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    /*后序遍历-非递归*/
    private static List<Integer> postOrderTraversalNotRecursion(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();
        stack.push(root);
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
            }
            stack.push(cur);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            if (cur == stack.peek()) {
                values.add(cur.val);
                cur = stack.pop();
            }
            cur = stack.pop();
        }
        return null;
    }
}
