package cn.phorcys.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Wonder
 * @Date: Created on 2021/11/2 下午12:17
 */
public class S27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        /*递归翻转左右子树*/
        TreeNode newLeft = null;
        if (root.left != null) {
            newLeft = mirrorTree(root.left);
        }
        TreeNode newRight = null;
        if (root.right != null) {
            newRight = mirrorTree(root.right);
        }
        root.left = newRight;
        root.right = newLeft;
        return root;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 2, 7, 1, 3, 6, 9);
        Integer[] array = (Integer[]) arr.toArray();
        TreeNode node = BinaryTreeTraverse.getTreeFromArray(array);
        TreeNode treeNode = new S27().mirrorTree(node);
    }
}
