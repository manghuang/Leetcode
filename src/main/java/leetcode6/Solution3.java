package leetcode6;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution3 {
//    public int[] intersect(int[] nums1, int[] nums2) {
//        if(nums1 == null || nums1.length == 0 || nums2 == null
//        || nums2.length == 0){
//            return new int[0];
//        }
//        ArrayList<Integer> res = new ArrayList<>();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int index1 = 0;
//        int index2 = 0;
//        while (index1 < nums1.length && index2 <nums2.length){
//            int temp = nums1[index1];
//            while (index2 < nums2.length){
//                if(nums2[index2] < temp){
//                    index2++;
//                }else if(nums2[index2] == temp) {
//                    res.add(temp);
//                    index2++;
//                    break;
//                }else {
//                    break;
//                }
//            }
//            index1++;
//        }
//        int[] ans = new int[res.size()];
//        for (int i = 0; i <res.size() ; i++) {
//            ans[i] = res.get(i);
//        }
//        return ans;
//    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null
                || nums2.length == 0) {
            return new int[0];
        }
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] s, l;
        if (nums1.length < nums2.length) {
            s = nums1;
            l = nums2;
        } else {
            s = nums2;
            l = nums1;
        }
        for (int value : s) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }
        for (int value :
                l) {
            if (hashMap.containsKey(value) && hashMap.get(value) > 0) {
                res.add(value);
                hashMap.put(value, hashMap.get(value) - 1);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
