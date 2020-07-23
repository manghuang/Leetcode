package leetcode2;

public class Solution8 {
    // O(nlgn)的时间复杂度，O(1)的空间复杂度, 不满足不能改变原数组的条件
    // 如果copy一个数组，则不满足O(1)的空间复杂度的条件
//    public int findDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        int temp = nums[0];
//        for (int i = 1; i <nums.length ; i++) {
//            if(nums[i] == temp){
//                return temp;
//            }
//            temp = nums[i];
//        }
//        return temp;
//    }
    //直接在原数组上操作，不能改变原数组，时间复杂度还是要O(nlgn)
    //二进制
    //二分查找
    //Floyd判圈算法
    public int findDuplicate(int[] nums) {
        return 0;
    }
}
