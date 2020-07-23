package leetcode4;

public class Solution14 {

    /*
        方式一：双指针，但不是左右双指针，而是可能子数组解的的前后双指针
        方式二：二分查找大于等于某个数的第一个位置的功能
     */
    /*
            前闭后开
     */
//    public int minSubArrayLen(int s, int[] nums) {
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//        int begin = 0;
//        int end = 0;
//        int res = Integer.MAX_VALUE;
//        int sum = 0;
//        while (end <= nums.length){
//            if(sum < s){
//                if(end < nums.length){
//                    sum += nums[end];
//                }
//                end++;
//            }else {
//                res = Math.min(res, (end - begin));
//                while (begin <= end){
//                    if(sum - nums[begin] >= s){
//                        sum -= nums[begin];
//                        begin++;
//                        res = Math.min(res, (end- begin));
//                    }else {
//                        if(end < nums.length){
//                            sum += nums[end];
//                        }
//                        end++;
//                        break;
//                    }
//                }
//            }
//        }
//        if(res == Integer.MAX_VALUE){
//            return 0;
//        }else {
//            return res;
//        }
//    }


    /*
            前闭后开
     */
//    public int minSubArrayLen(int s, int[] nums) {
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//        int begin = 0;
//        int end = 0;
//        int res = Integer.MAX_VALUE;
//        int sum = 0;
//        while (end < nums.length){
//           sum += nums[end];
//           while (sum >= s){
//               res= Math.min(res, (end- begin+1));
//               sum -= nums[begin];
//               begin++;
//           }
//           end++;
//        }
//        if(res == Integer.MAX_VALUE){
//            return 0;
//        }else {
//            return res;
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int s = 15;
        int res = new Solution14().minSubArrayLen(s, nums);
        System.out.println(res);
    }

    /*
        前开后闭
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int begin = -1;
        int end = -1;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length) {
            if (sum < s) {
                end++;
                if (end < nums.length) {
                    sum += nums[end];
                }
            } else {
                res = Math.min(res, (end - begin));
                begin++;
                sum -= nums[begin];
            }
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        } else {
            return res;
        }
    }
}
