package leetcode1;

public class Solution17 {
    public int mySqrt(int x) {
//        int result = 0;
//        result = (int)Math.sqrt(x);
//        return result;
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
