package leetcode3;

import java.util.HashMap;

public class Solution6 {
    /*
        因为排序了，所以时间复杂度为O(nlgn)，空间复杂度为O(1)
        要求时间复杂度是O(n)，要用空间来换时间
        并查集
        哈希表/set表，优化查询时间，O(1)
     */

    public static void main(String[] args) {
        int[] a = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        int res = new Solution6().longestConsecutive(a);
        System.out.println(res);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        UnionFind uf = new UnionFind(nums);
        for (int num : nums) {
            if (uf.fatherMap.containsKey(num - 1)) {
                uf.union(num - 1, num);
            }
        }
        return uf.max;
    }

//    public int longestConsecutive(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//
//        int res = 0;
//        HashSet<Integer> hs = new HashSet<>();
//        for (int num:
//             nums) {
//            hs.add(num);
//        }
//        for (int num:
//             hs) {
//            if(hs.contains(num-1)){
//                continue;
//            }
//            int count = 1;
//            while (hs.contains(num+1)){
//                count++;
//                num++;
//            }
//            res = Math.max(res, count);
//        }
//
//        return res;
//
//    }
//    public int longestConsecutive(int[] nums) {
//
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//
//        Arrays.sort(nums);
//        int res = 1;
//        int temp = 1;
//        for (int i=1; i<nums.length; i++){
//            if(nums[i] == nums[i-1] +1){
//                temp++;
//            }else if(nums[i] == nums[i-1]){
//            }else {
//                res = Math.max(res, temp);
//                temp=1;
//            }
//        }
//        res = Math.max(res, temp);
//        return res;
//    }

    public class UnionFind {
        int max;
        HashMap<Integer, Integer> fatherMap;
        HashMap<Integer, Integer> sizeMap;

        public UnionFind(int[] nums) {
            max = 1;//处理nums中只有一个元素的情况下，默认为1
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (int val : nums) {
                fatherMap.put(val, val);
                sizeMap.put(val, 1);
            }
        }

        public int findFather(int val) {
            int father = fatherMap.get(val);
            if (father != val) {
                father = findFather(father);
            }
            fatherMap.put(val, father);
            return father;
        }

        public void union(int a, int b) {
            int aFather = findFather(a);
            int bFather = findFather(b);
            if (aFather != bFather) {
                int aSize = sizeMap.get(aFather);
                int bSize = sizeMap.get(bFather);
                if (aSize <= bSize) {
                    fatherMap.put(aFather, bFather);
                    sizeMap.put(bFather, aSize + bSize);
                } else {
                    fatherMap.put(bFather, aFather);
                    sizeMap.put(aFather, aSize + bSize);
                }
                max = Math.max(max, aSize + bSize);
            }
        }
    }
}
