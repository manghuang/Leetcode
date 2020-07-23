package leetcode4;

public class Solution6 {

    /*
        遍历得到字符串数组中每个字符串的0和1的个数，mi, ni
        方式一；然后枚举每一种组合，计算0和1的和，在满足sumM <= m, sumN <= n 的情况下，求得组合的字符串的最大个数
               枚举过程通过dps, 对于某一个字符串，只有要和不要两种情况
                        第一种：直接深度优先算法:无法拆出子问题
                        第二种：回溯：可以拆除子问题，但是状态不好记录

         方式二：考虑01背包问题来优化dps，动态规划, 两个限定条件用三维dp数组
                自上而下，从左到右填表
     */

    /*
      int[][] dp = new int[n][n];  只需要这样就完成了二维数组的初始化
     */

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int res = new Solution6().findMaxForm(strs, 1, 1);
        System.out.println(res);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        /*
            nums用来存储每个字符串中0和1的个数
         */
        int[][] nums = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int index = 0;
            while (index < strs[i].length()) {
                if (strs[i].charAt(index) == '0') {
                    nums[i][0]++;
                } else {
                    nums[i][1]++;
                }
                index++;
            }
        }
        /*
            res用来存储动态规划计算过程中产生的状态
            其中res[i][j][k]代表：前j个字符串中进行组合，组合后的0的个数<=j, 1的个数<=k，这种条件下最大的字符串个数
         */
        int[][][] res = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i < strs.length + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                //m不够
                if (j < nums[i - 1][0]) {
                    if (n + 1 >= 0) System.arraycopy(res[i - 1][j], 0, res[i][j], 0, n + 1);
                }
                //m够
                else {
                    for (int k = 0; k < n + 1; k++) {
                        //n不够
                        if (k < nums[i - 1][1]) {
                            res[i][j][k] = res[i - 1][j][k];
                        }
                        //n够
                        else {
                            res[i][j][k] = Math.max(res[i - 1][j][k], res[i - 1][j - nums[i - 1][0]][k - nums[i - 1][1]] + 1);
                        }
                    }
                }

            }
        }
        /*
            最终表的右下角的数值就是结果
         */
        return res[strs.length][m][n];
    }

    private int dps(int index, int[][] nums, int m, int n) {
        if (index >= nums.length || m < 0 || n < 0) {
            return 0;
        }
        // 不要
        int noRes = dps(index + 1, nums, m, n);
        //要
        int yesRes = 0;
        if (m - nums[index][0] >= 0 && n - nums[index][1] >= 0) {
            yesRes = dps(index + 1, nums, m - nums[index][0], n - nums[index][1]) + 1;
        }
        return Math.max(noRes, yesRes);
    }
}
