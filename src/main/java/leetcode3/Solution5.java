package leetcode3;

import java.util.Arrays;

public class Solution5 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = new Solution5().spiralOrder(a);
        System.out.println(Arrays.toString(res));
    }

    /*
        state不需要
        x,y 不需要
        只需要确定好四个边界
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null
                || matrix[0].length == 0) {
            return new int[0];
        }
        /*
            -1:init
            0:right  ->1
            1:down   ->2
            2:left   ->3
            3:up     ->0
         */
        int state = -1;

        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int[] res = new int[xLength * yLength];
        int index = 0;

        /*
            0:right
            1:down
            2:left
            3:up
         */
        int[] temp = new int[4];

        int x = 0;
        int y = 0;
        while (true) {
            state = (state + 1) % 4;

            if (state == 0) {
                if (y >= yLength - temp[0]) {
                    break;
                }
                while (y < yLength - temp[0]) {
                    res[index++] = matrix[x][y];
                    y++;
                }
                x++;
                y--;
                temp[3]++;
            } else if (state == 1) {
                if (x >= xLength - temp[1]) {
                    break;
                }
                while (x < xLength - temp[1]) {
                    res[index++] = matrix[x][y];
                    x++;
                }
                x--;
                y--;
                temp[0]++;
            } else if (state == 2) {
                if (y < temp[2]) {
                    break;
                }
                while (y >= temp[2]) {
                    res[index++] = matrix[x][y];
                    y--;
                }
                x--;
                y++;
                temp[1]++;
            } else {
                if (x < temp[3]) {
                    break;
                }
                while (x >= temp[3]) {
                    res[index++] = matrix[x][y];
                    x--;
                }
                x++;
                y++;
                temp[2]++;
            }

        }
        return res;
    }
}
