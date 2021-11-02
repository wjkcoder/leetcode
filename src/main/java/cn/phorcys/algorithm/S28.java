package cn.phorcys.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Wonder
 * @Date: Created on 2021/11/2 下午2:56
 */
public class S28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        /*遍历子树记录每一个节点的路径*/
        List<Integer> leftValues = getList(root.left, true);
        List<Integer> rightValues = getList(root.right, false);
        if (leftValues.size() != rightValues.size()) return false;
        int i = leftValues.size() - 1;
        while (i >= 0) {
            Integer left = leftValues.get(i);
            Integer right = rightValues.get(i);
            if ((left != null && left.equals(right)) || (left == null && right == null)) {
                i--;
            } else return false;
        }
        return true;
    }

    public List<Integer> getList(TreeNode root, boolean isLeft) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> values = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                values.add(null);
                continue;
            }
            values.add(node.val);
            if (node.left == null && node.right == null) continue;
            if (isLeft) {
                stack.push(node.left);
                stack.push(node.right);
            } else {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return values;
    }

    public boolean isSymmetricRec(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return recur(root.left, root.right);
    }

    boolean recur(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return recur(node1.left, node2.right) && recur(node1.right, node2.left) && node1.val == node2.val;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 2, null, 3, 3);
        Integer[] array = (Integer[]) arr.toArray();
        TreeNode node = BinaryTreeTraverse.getTreeFromArray(array);
        boolean symmetric = new S28().isSymmetric(node);
        System.out.println(symmetric);
    }

}
