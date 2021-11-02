package cn.phorcys.algorithm;

/**
 * @Author: Wonder
 * @Date: Created on 2021/11/1 上午11:22
 */
public class S04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int columnLength = matrix[0].length;
        int row = 0;
        int column = columnLength - 1;
        while (column >= 0 && row < matrix.length) {
            int maxValue = matrix[row][column];
            if (maxValue == target) return true;
            if (maxValue < target) {
                row += 1;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrixArr = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean numberIn2DArray = new S04().findNumberIn2DArray(matrixArr, 5);
        System.out.println(numberIn2DArray);
    }
}
