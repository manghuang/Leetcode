package newyear.leetcode3.notebook;

import java.util.LinkedList;

public class Solution7 {

    public int[][] generateMatrix(int n) {
        if(n <= 0){
            return new int[0][0];
        }
        if(n == 1){
            return new int[][]{{1}};
        }
        int index = 1;
        int[][] ans = new int[n][n];

        int front = 0;
        int behind = n-1;
        int left = 0;
        int right = n-1;
        int x = 0, y = -1;
        int direction = 0;
        int[] X = {0, 1, 0, -1};
        int[] Y = {1, 0, -1, 0};
        while (front <= behind && left <= right) {
            int newX = x + X[direction];
            int newY = y + Y[direction];
            if (newX < front || newX > behind || newY < left || newY > right) {
                direction = (direction + 1) % 4;
                if (newX < front) {
                    left++;
                } else if (newX > behind) {
                    right--;
                } else if (newY < left) {
                    behind--;
                } else {
                    front++;
                }
                continue;
            }
            ans[newX][newY] = index;
            x = newX;
            y = newY;
            index++;
        }

        return ans;
    }
}
