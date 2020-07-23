package leetcode1;

import java.util.HashMap;

public class Solution20 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int pre = 0;
        hashMap.put(pre, 1);
        for (int i = 0; i < nums.length; i++) {
//            int temp = 0;
//            for(int j=i; j<nums.length; j++){
//                temp += nums[j];
//                if(temp == k){
//                    ans++;
//                }
//            }
            pre += nums[i];
            if (hashMap.containsKey(pre - k)) {
                ans += hashMap.get(pre - k);
            }
            if (hashMap.containsKey(pre)) {
                hashMap.put(pre, hashMap.get(pre) + 1);
            } else {
                hashMap.put(pre, 1);
            }
        }

        return ans;
    }
}
