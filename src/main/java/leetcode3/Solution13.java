package leetcode3;

import java.util.Arrays;

public class Solution13 {


    /*
       排序
       二分查找：比线性查找效率高
     */
    public int findBestValue(int[] arr, int target) {

        Arrays.sort(arr);
        int length = arr.length;
//        int i1 = Arrays.binarySearch(arr, 0);
        int index = -1;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int temp = sum + (length - i - 1) * arr[i];
            if (temp >= target) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return arr[length - 1];
        }

        int res = arr[index];
        sum -= arr[index];
        index--;
        //大于等于0
        int dis = sum + (length - index - 1) * res - target;
        while (true) {
            res--;
            int temp = sum + (length - index - 1) * res - target;
            if (temp >= 0) {
                dis = temp;
            } else {
                if (Math.abs(temp) <= dis) {
                    break;
                } else {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

}
