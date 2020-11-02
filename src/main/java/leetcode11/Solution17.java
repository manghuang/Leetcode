package leetcode11;

import java.util.*;

public class Solution17 {

//    public int[] intersection(int[] nums1, int[] nums2) {
//        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
//            return new int[0];
//        }
//        List<Integer> list = new ArrayList<>();
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//        int index1 = 0;
//        int index2 = 0;
//        while (index1 < length1 && index2 <length2){
//            if(nums1[index1] < nums2[index2]){
//                index1++;
//            }else if(nums1[index1] == nums2[index2]){
//                list.add(nums1[index1]);
//                index1++;
//                while (index1 < length1 && nums1[index1] == nums1[index1-1]){
//                    index1++;
//                }
//                index2++;
//                while (index2 < length2 && nums2[index2] == nums2[index2-1]){
//                    index2++;
//                }
//            }else {
//                index2++;
//            }
//        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i <list.size() ; i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }
        public int[] intersection(int[] nums1, int[] nums2) {
            if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
                return new int[0];
            }
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int num:nums1
                 ) {
                set1.add(num);
            }
            for (int num:nums2
                 ) {
                set2.add(num);
            }
            List<Integer> list = new ArrayList<>();
            for (Integer val : set1) {
                if (set2.contains(val)) {
                    list.add(val);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i <list.size() ; i++) {
                res[i] = list.get(i);
            }
            return res;
        }


}
