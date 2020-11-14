package parse;

import java.util.*;

public class Solution32 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0){
            return arr1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int val: arr2
             ) {
            int num = map.get(val);
            map.remove(val);
            while (num > 0){
                arr1[index++] = val;
                num--;
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (Map.Entry<Integer, Integer> entry: list
             ) {
            int val = entry.getKey();
            int num = entry.getValue();
            while (num > 0){
                arr1[index++] = val;
                num--;
            }
        }
        return arr1;
    }
}
