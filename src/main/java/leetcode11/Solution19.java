package leetcode11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution19 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || (intervals.length != 0 && intervals[0].length != 2)){
            return null;
        }
        if(newInterval == null || newInterval.length != 2){
            return intervals;
        }


        int length = intervals.length;
        boolean sureLeft = false;
        int leftIndex = -1;
        int rightIndex = -2;
        for (int i = 0; i <length ; i++) {
            int[] interval = intervals[i];
            if(!sureLeft){
                if(newInterval[0] <= interval[0] || newInterval[0] <= interval[1]){
                    leftIndex = i;
                    i--;
                    sureLeft = true;
                }
            }else {
                if(newInterval[1] < interval[0]){
                    rightIndex = i-1;
                    break;
                }else if(newInterval[1] <= interval[1]){
                    rightIndex = i;
                    break;
                }
            }
        }
        if(leftIndex == -1){
            int[][] res = new int[length+1][];
            System.arraycopy(intervals, 0, res, 0, length);
            res[length] = newInterval;
            return res;
        }else if(rightIndex == -1){
            int[][] res = new int[length+1][];
            res[0] = newInterval;
            System.arraycopy(intervals, 0, res, 1, length);
            return res;
        }else if(rightIndex == -2){
            int[][] res = new int[leftIndex+1][];
            System.arraycopy(intervals, 0, res, 0, leftIndex);
            res[leftIndex] = new int[2];
            res[leftIndex][1] = newInterval[1];
            res[leftIndex][0] = Math.min(newInterval[0], intervals[leftIndex][0]);
            return res;
        }else {
            int[][] res = new int[length-rightIndex+leftIndex][];
            System.arraycopy(intervals, 0, res, 0, leftIndex);
            res[leftIndex] = new int[2];
            res[leftIndex][0] = Math.min(newInterval[0], intervals[leftIndex][0]);
            res[leftIndex][1] = Math.max(newInterval[1], intervals[rightIndex][1]);
            for (int i = rightIndex+1; i <length ; i++) {
                res[++leftIndex] = intervals[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] ints = new int[2][];
        ints[0] = new int[]{1,3};
        ints[1] = new int[]{6,9};

        int[][] res = new Solution19().insert(ints, new int[]{2, 5});
        for (int[] re: res
             ) {
            System.out.println(Arrays.toString(re));
        }


    }
}
