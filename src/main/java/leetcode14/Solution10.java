package leetcode14;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution10 {



    /*
        (i-1, j-1) (i-1, j)
        (i, j-1) (i, j)
        正方形：边长
        矩阵：高度
     */
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int xLength = matrix.length;
        int yLength = matrix[0].length;

        // 0:矩阵的长， 1:矩阵的宽
        int[][][] dp = new int[xLength][yLength][2];
        if(matrix[0][0] == '1'){
            dp[0][0][0] = 1;
            dp[0][0][1] = 1;
        }
        for (int i = 1; i < xLength; i++) {
            if(matrix[i][0] == '1'){
                dp[i][0][0] = 1;
                dp[i][0][1] = dp[i-1][0][1] + 1;
            }
        }
        for (int j= 1; j < yLength ; j++) {
            if(matrix[0][j] == '1'){
                dp[0][j][0] = dp[0][j-1][0] + 1;
                dp[0][j][1] = 1;
            }
        }
        for (int i = 1; i <xLength ; i++) {
            for (int j = 1; j <yLength ; j++) {
                if(matrix[i][j] == '1'){
                    dp[i][j][0] = dp[i][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j][1] + 1;
                }
            }
        }

        // 以（i,j）为右下角的柱状图最大矩阵面积，O(n2)
        int res = 0;
//        for (int i = 0; i < xLength; i++) {
//            for (int j = 0; j < yLength; j++) {
//                if(matrix[i][j] == '0'){
//                    continue;
//                }
//                int length = dp[i][j][0];
//                int maxHeight = dp[i][j][1];
//                int area = 0;
//                for (int h = 0; h < maxHeight; h++) {
//                    length = Math.min(length, dp[i-h][j][0]);
//                    area = Math.max(area, length * (h+1));
//                }
//                res = Math.max(res, area);
//            }
//        }
        // 以（i,j）为底的柱状图的最大矩阵面积,固定高度，求左右边界 O(n2)，优化后O(n)
        // 边界差 * 高度
        // 最大值一定在里面
//        for (int i = 0; i < xLength; i++) {
//            for (int j = 0; j < yLength; j++) {
//                System.out.print(dp[i][j][1] + "  ");
//            }
//            System.out.println();
//        }
        System.out.println();
        for (int i = 0; i < xLength; i++) {
            int[] left = new int[yLength];
            int[] right = new int[yLength];
            LinkedList<Integer> stack = new LinkedList<>();
            for (int j = 0; j < yLength; j++) {
                while (!stack.isEmpty() && dp[i][j][1] <= dp[i][stack.peek()][1]){
                    stack.pop();
                }
                left[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }
            stack.clear();
            for (int j = yLength-1; j >= 0 ; j--) {
                while (!stack.isEmpty() && dp[i][j][1] <= dp[i][stack.peek()][1]){
                    stack.pop();
                }
                right[j] = stack.isEmpty() ? yLength : stack.peek();
                stack.push(j);
            }
//            System.out.println(Arrays.toString(left));
//            System.out.println(Arrays.toString(right));
            for (int j = 0; j < yLength; j++) {
                int area = dp[i][j][1] * (right[j] - left[j] - 1);
//                System.out.print(area + "  ");
                res = Math.max(res, area);
            }
            System.out.println();
        }
        // 固定宽度，求高度， O(n2)
        return res;
    }



    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = new Solution10().maximalRectangle(matrix);
        System.out.println(res);
    }
}
