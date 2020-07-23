package leetcode0;

import java.util.Arrays;

class Solution9 {
    public static void main(String[] args) {
        int result = new Solution9().movingCount(54, 89, 20);
        System.out.println(result);
    }

    public int movingCount(int m, int n, int k) {
        //暴力
        //数学

        int result = 0;

        int[] temp = new int[30];
        int a = k + 1;
        for (int i = 0; i < 30; i++) {
            if (a > 0) {
                temp[i] = Math.min(a, 10);
            } else {
                temp[i] = 0;
            }
            a--;
        }
        System.out.println(Arrays.toString(temp));

        for (int i = 0; i < m; i++) {
            int rowIndex = i / 10;
            if (rowIndex != 0 && temp[rowIndex + 8] == 0) break;

            for (int j = 0; j < n; j = j + 10) {
                int colounIndex = j / 10;
                if (colounIndex != 0 && temp[rowIndex + colounIndex + 8] == 0) break;
                int b = n - j;
                if (b < 10) {
                    result = result + Math.min(b, temp[rowIndex + colounIndex + i % 10]);
                } else {
                    result = result + temp[rowIndex + colounIndex + i % 10];
                }
            }

        }
        return result;
    }
}