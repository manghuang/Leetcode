package leetcode11;

import java.util.*;

public class Solution21 {

    public int[] sortByBits(int[] arr) {
        if(arr == null || arr.length == 0){
            return null;
        }
        int length = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int value : arr) {
            if (!hashMap.containsKey(value)) {
                hashMap.put(value, getOneNum(value));
            }
            list.add(value);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (!Objects.equals(hashMap.get(o1), hashMap.get(o2))) {
                    return hashMap.get(o1) - hashMap.get(o2);
                } else {
                    return o1 - o2;
                }
            }
        });

//        for (int i = 0; i <length ; i++) {
//            for (int j = i+1; j <length ; j++) {
//                if(hashMap.get(arr[i]) > hashMap.get(arr[j])){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }else if(Objects.equals(hashMap.get(arr[i]), hashMap.get(arr[j]))){
//                    if(arr[i] > arr[j]){
//                        int temp = arr[i];
//                        arr[i] = arr[j];
//                        arr[j] = temp;
//                    }
//                }
//            }
//        }
        int[] res = new int[length];
        for (int i = 0; i <length ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int getOneNum(int num) {
//        if(num == 1){
//            return 1;
//        }else if(num == 0){
//            return 0;
//        }
//        return ((num % 2 == 1) ? 1 : 0) + getOneNum(num / 2);
        int res = 0;
        while (num > 0){
            res += num & 1;
            num = num >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution21().getOneNum(3);
        System.out.println(res);
    }
}
