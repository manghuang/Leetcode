package leetcode0;

import java.util.Arrays;

public class Solution8 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution8().rotate(a);
        System.out.println(Arrays.toString(a));
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] temp = new int[length][length];
        System.arraycopy(matrix, 0, temp, 0, length);
        System.out.println(Arrays.toString(temp));
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = temp[length - 1 - j][i];
            }
        }
    }
}

