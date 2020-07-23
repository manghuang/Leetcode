package leetcode1;

public class Solution5 {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 0, 4};
        boolean isok = new Solution5().canJump(a);
        System.out.println(isok);
    }

//    private boolean dfs(int[] nums, int index) {
//        if(index >= nums.length-1){
//            return true;
//        }
//        for(int i=nums[index]; i>=1; i--){
//            boolean isok = dfs(nums, index+i);
//            if(isok){
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
//        int index = 0;
//        boolean isok = dfs(nums, index);
//        return isok;

        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            int step = i + nums[i];
            if (step > maxStep) {
                maxStep = step;
            }
            if (step >= nums.length - 1) {
                return true;
            }
            if (nums[i] <= 0) {
                if (maxStep <= i) {
                    return false;
                }
            }
        }
        return true;
    }
}
