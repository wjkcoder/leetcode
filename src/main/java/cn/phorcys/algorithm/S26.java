package cn.phorcys.algorithm;

/**
 * @Author: Wonder
 * @Date: Created on 2021/11/2 下午4:02
 */
public class S26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /*判断B是否为A的子树*/
        if (A == null) return false;
        if (B == null) return false;
        if (A.val == B.val && isSubStructureRec(A, B)) return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean isSubStructureRec(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return isSubStructureRec(A.left, B.left) && isSubStructureRec(A.right, B.right);
    }
}
