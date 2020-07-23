package leetcode1;

public class Solution19 {
    public int singleNumber(int[] nums) {
        int anx = 0;

        for (int num : nums) {
            anx = anx ^ num;
        }

        return anx;
    }
}
