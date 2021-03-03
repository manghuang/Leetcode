package newyear.leetcode1;

public class Solution0 {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = get(i);
        }
        return ans;
    }

    private int get(int num) {
        int count = 0;
        while (num != 0){
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }
}
