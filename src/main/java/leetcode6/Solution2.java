package leetcode6;

import java.util.Arrays;

public class Solution2 {
    /*
        dps
     */
//    private int ans = Integer.MAX_VALUE;
//    public int calculateMinimumHP(int[][] dungeon) {
//        if(dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0){
//            return 0;
//        }
//        dps(dungeon, 0, 0, 0, 1);
//        return this.ans;
//    }
//
//    private void dps(int[][] dungeon, int x, int y, int blood, int maxBlood) {
//        blood = blood + dungeon[x][y];
//        if(blood < 0){
//            maxBlood = Math.max(maxBlood,-blood+1);
//        }
//        if(maxBlood >= this.ans){
//            return;
//        }
//        if(x == dungeon.length-1 && y == dungeon[0].length-1){
//            this.ans = Math.min(this.ans, maxBlood);
//            return;
//        }
//        if(y < dungeon[0].length-1){
//            dps(dungeon, x, y+1, blood, maxBlood);
//        }
//        if(x < dungeon.length-1){
//            dps(dungeon, x+1, y, blood, maxBlood);
//        }
//
//    }

    /*
        dps+回溯+dp数组优化
     */
    private int[][] dp;

    public static void main(String[] args) {
        int[][] d = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int ans = new Solution2().calculateMinimumHP(d);
        System.out.println(ans);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }
        this.dp = new int[dungeon.length][dungeon[0].length];
        for (int[] a :
                this.dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        return dps(dungeon, 0, 0);

    }
    /*
        动态规划
     */

    private int dps(int[][] dungeon, int x, int y) {
        int value = dungeon[x][y];
        if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
            return Math.max(1 - value, 1);
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if (y < dungeon[0].length - 1) {
            if (dp[x][y + 1] == Integer.MAX_VALUE) {
                a = dps(dungeon, x, y + 1);
                dp[x][y + 1] = a;
            } else {
                a = dp[x][y + 1];
            }
            a = Math.max(a - value, 1);
        }
        if (x < dungeon.length - 1) {
            if (dp[x + 1][y] == Integer.MAX_VALUE) {
                b = dps(dungeon, x + 1, y);
                dp[x + 1][y] = b;
            } else {
                b = dp[x + 1][y];
            }
            b = Math.max(b - value, 1);
        }
        return Math.min(a, b);
    }

}
