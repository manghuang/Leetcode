package leetcode4;

public class Solution1 {
    public int maxScoreSightseeingPair(int[] A) {
        int res = Integer.MIN_VALUE;
        int mx = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = mx + A[i] - i;
            res = Math.max(res, temp);
            mx = Math.max(mx, A[i] + i);
        }
        return res;
    }
}
