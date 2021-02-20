package newyear.leetcode0;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 第一个位置，最后一个位置，出现的次数
    // 先按次数排序，然后按长度排序
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if(map.containsKey(nums[i])){
                int[] temp = map.get(nums[i]);
                temp[1] = i - temp[0] + 1;
                temp[2]++;
            }else {
                int[] temp = new int[]{i, 1, 1};
                map.put(nums[i], temp);
            }
        }
        int ans = nums[0];
        for (int key:
             map.keySet()) {
            if(map.get(key)[2] > map.get(ans)[2]){
                ans = key;
            }else if(map.get(key)[2] == map.get(ans)[2]) {
                if(map.get(key)[1] < map.get(ans)[1]){
                    ans = key;
                }
            }
        }
        return map.get(ans)[1];
    }
}
