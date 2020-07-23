package leetcode5;

public class Solution10 {

    public static void main(String[] args) {
        char[][] nums = {{'0', '1'}};
        int res = new Solution10().maximalRectangle(nums);
        System.out.println(res);
    }

    /*
        方式一：暴力枚举   O(n4)
        方式二：动态规划    柱状图找最大面积
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int res = 0;
        int temp;
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                temp = yLength;
                for (int k = i; k < xLength; k++) {
                    if (matrix[k][j] == '0') {
                        break;
                    }
                    for (int l = j; l < temp; l++) {
                        if (matrix[k][l] == '0') {
                            temp = l;
                            break;
                        }
                        res = Math.max(res, (k - i + 1) * (l - j + 1));
                    }
                }

            }
        }
        return res;
    }

}
