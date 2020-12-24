package leetcode14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution9 {

//    private int[] res;

//    public int candy(int[] ratings) {
//        if(ratings == null || ratings.length == 0){
//            return 0;
//        }
//        if(ratings.length == 1){
//            return 1;
//        }
//        int length = ratings.length;
//        res = new int[length];
//
//        dfs(ratings, 0, length-1);
//
//        int temp  = 0;
//        for (int i = 0; i <length ; i++) {
//            temp += res[i];
//        }
//        return temp;
//    }
//
//    private void dfs(int[] ratings, int leftIndex, int rightIndex) {
//        if(leftIndex > rightIndex){
//            return;
//        }
//        int minIndex = leftIndex;
//        for (int i = leftIndex+1; i <= rightIndex ; i++) {
//            if(ratings[i] < ratings[minIndex]){
//                minIndex = i;
//            }
//        }
//        if(minIndex == 0){
//            res[minIndex] = rightRes(ratings, minIndex);
//        }else if(minIndex == ratings.length-1){
//            res[minIndex] = leftRes(ratings, minIndex);
//        }else {
//            res[minIndex] = rightRes(ratings, minIndex);
//            res[minIndex] = Math.max(res[minIndex], leftRes(ratings, minIndex));
//        }
//        dfs(ratings, leftIndex, minIndex-1);
//        dfs(ratings, minIndex+1, rightIndex);
//    }
//
//    private int leftRes(int[] ratings, int minIndex) {
//        if(res[minIndex-1] == 0){
//            return 1;
//        }else {
//            if(ratings[minIndex] == ratings[minIndex-1]){
//                return 1;
//            }else {
//                return res[minIndex-1]+1;
//            }
//        }
//    }
//
//    private int rightRes(int[] ratings, int minIndex) {
//        if(res[minIndex+1] == 0){
//            return 1;
//        }else {
//            if(ratings[minIndex] == ratings[minIndex+1]){
//                return 1;
//            }else {
//                return res[minIndex+1]+1;
//            }
//        }
//    }

//    public int candy(int[] ratings) {
//        if(ratings == null || ratings.length == 0){
//            return 0;
//        }
//        if(ratings.length == 1){
//            return 1;
//        }
//        int length = ratings.length;
//        int[] res = new int[length];
//
//        dfs(ratings, res, 0);
//
//        int temp = 0;
//        for (int i = 0; i <length ; i++) {
//            temp += res[i];
//        }
//        return temp;
//    }
//
//    private boolean dfs(int[] ratings, int[] res, int index) {
//        if(index >= ratings.length){
//            return true;
//        }
//        int minValue = 1;
//        int maxValue = Integer.MAX_VALUE;
//        if(index != 0){
//            if(ratings[index] > ratings[index-1]){
//                minValue = res[index-1]+1;
//            }else if(ratings[index] < ratings[index-1]){
//                maxValue = res[index-1]-1;
//            }
//        }
//        for(int i=minValue; i<= maxValue; i++){
//            res[index] = i;
//            if(dfs(ratings, res, index+1)){
//                return true;
//            }
//        }
//        return false;
//    }

    /*
        规则分为两条，左规则和右规则
        首先一次遍历满足左规则
        第二次遍历满足右规则
        证明：第二次遍历不会破坏第一次遍历满足的左规则
            任意两个相邻的数只能是其中左规则或者右规则的一种，
            1  0   2
            1  1   2
            2  1   2
     */
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        if(ratings.length == 1){
            return 1;
        }
        int length = ratings.length;
        int[] res = new int[length];
        Arrays.fill(res, 1);
        for (int i = 1; i <length ; i++) {
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1]+1;
            }
        }
        for (int i = length-2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i], res[i+1] + 1);
            }
        }
        int temp = 0;
        for (int i = 0; i <length ; i++) {
            temp += res[i];
        }
        return temp;
    }
    public static void main(String[] args) {
        int res = new Solution9().candy(new int[]{1, 0, 2});
        System.out.println(res);
    }
}
