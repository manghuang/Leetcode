package newyear.leetcode3.notebook;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int front = 0;
        int behind = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        LinkedList<Integer> ans = new LinkedList<>();
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
            ans.add(matrix[newX][newY]);
            x = newX;
            y = newY;
        }
        return ans;

    }
}
