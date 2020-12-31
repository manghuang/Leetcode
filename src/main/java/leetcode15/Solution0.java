package leetcode15;

import java.util.*;



public class Solution0 {
/*
    一个关键：使用HashMap<Integer, HashSet<Integer>>数据结构来存储index对应区间有重叠的区间的index
            不同转为ArrayList,进行重排序，因为只要拿到最大值，一次循环后顺序会变化
             这样将复杂度从O(n2)降到O(n)
     这个贪心算法可能解不是最小值，有错
     */
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0){
//            return 0;
//        }
//
//        int res = 0;
//
//        // 排序
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o1[1]){
//                    return o1[1] - o2[1]; // 从小到大
//                }else {
//                    return o1[0] - o2[0]; // 从小到大
//                }
//            }
//        });
//        // 存储每个index对应的重叠index
//        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
//
//        // 去重
//        ArrayList<int[]> arrayToList = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            if(i != 0 && intervals[i][0] == intervals[i-1][0] && intervals[i][1] == intervals[i-1][1]){
//                res++;
//                continue;
//            }else {
//                arrayToList.add(intervals[i]);
//            }
//        }
//
//        intervals = arrayToList.toArray(new int[0][0]);
////        System.out.println(Arrays.deepToString(intervals));
//        for(int i=0; i<intervals.length; i++){
//            for(int j=i-1; j>=0; j--){
//                if(intervals[i][0] >= intervals[j][1]){
//                    continue;
//                }else {
//
//                    if(hashMap.containsKey(i)){
//                        HashSet<Integer> hashSet = hashMap.get(i);
//                        hashSet.add(j);
//                    }else {
//                        HashSet<Integer> hashSet = new HashSet<>();
//                        hashSet.add(j);
//                        hashMap.put(i,hashSet);
//                    }
//                    if(hashMap.containsKey(j)){
//                        HashSet<Integer> hashSet = hashMap.get(j);
//                        hashSet.add(i);
//                    }else {
//                        HashSet<Integer> hashSet = new HashSet<>();
//                        hashSet.add(i);
//                        hashMap.put(j, hashSet);
//                    }
//
//                }
//            }
//        }
//
////        ArrayList<Map.Entry<Integer, HashSet<Integer>>> arrayList= new ArrayList<>(hashMap.entrySet());
////        arrayList.sort(new Comparator<Map.Entry<Integer, HashSet<Integer>>>() {
////            @Override
////            public int compare(Map.Entry<Integer, HashSet<Integer>> o1, Map.Entry<Integer, HashSet<Integer>> o2) {
////                return o2.getValue().size() - o1.getValue().size();  // 从大到小
////            }
////        });
////        HashMap<Integer, Integer> mapToList = new HashMap<>();
////        for (int i = 0; i < arrayList.size(); i++) {
////            int key = arrayList.get(i).getKey();
////            mapToList.put(key, i);
////        }
////
////        while ( arrayList.size() > 0 && arrayList.get(0).getValue().size() > 0){
////            res++;
////            Map.Entry<Integer, HashSet<Integer>> entry = arrayList.get(0);
////            int x = entry.getKey();
////            for (int y : entry.getValue()
////                 ) {
////                Map.Entry<Integer, HashSet<Integer>> conEntry = arrayList.get(mapToList.get(y));
////                conEntry.getValue().remove(x);
////            }
////            entry.getValue().clear();
////            arrayList.sort((o1, o2) -> {
////                return o2.getValue().size() - o1.getValue().size();  // 重新排序
////            });
////            for (int i = 0; i < arrayList.size(); i++) {
////                int key = arrayList.get(i).getKey();
////                mapToList.put(key, i);
////            }
////        }
//        while (true){
//            int maxSizeIndex = -1;
//            int maxSize = 0;
//            for (int key: hashMap.keySet()
//                 ) {
//                int size = hashMap.get(key).size();
//                if( size > maxSize ){
//                    maxSizeIndex = key;
//                    maxSize = size;
//                }
//            }
//            if(maxSizeIndex == -1){
//                break;
//            }
//            res++;
//            for (int connectIndex: hashMap.get(maxSizeIndex)
//                 ) {
//                hashMap.get(connectIndex).remove(maxSizeIndex);
//            }
//            hashMap.get(maxSizeIndex).clear();
//        }
//        return res;
//    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int length = intervals.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for(int j = i-1; j >= 0; j--){
                if(intervals[j][1] <= intervals[i][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        return length - dp[length-1];
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}};
        int ans = new Solution0().eraseOverlapIntervals(a);
        System.out.println(ans);
    }
}
