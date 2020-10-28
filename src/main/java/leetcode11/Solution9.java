package leetcode11;

import java.util.*;

public class Solution9 {

    public boolean uniqueOccurrences(int[] arr) {
        if(arr == null || arr.length == 0){
            return true;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int value : arr) {
            if (hashMap.containsKey(value)) {
                hashMap.put(value, hashMap.get(value)+1);
            } else {
                hashMap.put(value, 1);
            }
        };
//        Integer[] values = hashMap.values().toArray(new Integer[0]);
//        Arrays.sort(values);
//        for (int i = 1; i <values.length ; i++) {
//            if(values[i].equals(values[i-1])){
//                return false;
//            }
//        }
        ArrayList<Integer> arrayList = new ArrayList<>(hashMap.values());
        Collections.sort(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i).equals(arrayList.get(i-1))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution9().uniqueOccurrences(new int[]{26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16});
    }
}
