package leetcode11;

import java.util.Arrays;

public class Solution22 {


    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if(arr == null || arr.length == 0 || k <= 0 || k > arr.length){
            return 0;
        }

        int length = arr.length;
        int res = 0;
        int temp = 0;
        for (int i = 0; i <length-k+1; i++) {
            if(i == 0){
                for(int j=i; j<i+k; j++){
                    temp += arr[j];
                }
            }else {
                temp = temp - arr[i-1] + arr[i+k-1];
            }
            if(temp / k >= threshold){
                res++;
            }
        }
        return res;
    }


}
