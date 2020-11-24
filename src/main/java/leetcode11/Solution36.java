package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Solution36 {

    /*
        时间复杂度：O(n2)
     */
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int length = gas.length;
//        int[] remainGas = new int[length];
//        for (int i = 0; i <length ; i++) {
//            remainGas[i] = gas[i] - cost[i];
//        }
//        for (int i = 0; i <length ; i++) {
//            if(isOk(remainGas, i)){
//                return i;
//            }
//        }
//        return -1;
//    }

//    private boolean isOk(int[] remainGas, int index) {
//        int length = remainGas.length;
//        int temp = 0;
//        for (int i = index; i <length ; i++) {
//            temp += remainGas[i];
//            if(temp < 0){
//                return false;
//            }
//        }
//        for (int i = 0; i <index ; i++) {
//            temp += remainGas[i];
//            if(temp < 0){
//                return false;
//            }
//        }
//        return true;
//    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] remainGas = new int[length];
        for (int i = 0; i <length ; i++) {
            remainGas[i] = gas[i] - cost[i];
        }
        int beginIndex = 0;
        int temp = 0;
        boolean isBegin = true;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <length ; i++) {
            if(isBegin) {
                temp += remainGas[i];
                if(remainGas[i] < 0){
                    isBegin = false;
                }
            }else {
                if(remainGas[i] > 0){
                    if(temp < 0){
                        list.add(new int[]{temp, beginIndex, i-1});
                        beginIndex = i;
                        temp = remainGas[i];
                    }else {
                        temp += remainGas[i];
                    }
                    isBegin = true;
                }else {
                    temp += remainGas[i];
                }
            }
        }
        list.add(new int[]{temp, beginIndex, length-1});
        for (int i = 0; i <list.size() ; i++) {
            if(isOk(list, i)){
                return list.get(i)[1];
            }
        }
        return -1;
    }

    private boolean isOk(List<int[]> list, int index) {
        int temp  =0;
        for (int i = index; i <list.size() ; i++) {
            temp += list.get(i)[0];
            if(temp < 0){
                return false;
            }
        }
        for (int i = 0; i <index ; i++) {
            temp += list.get(i)[0];
            if(temp < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] gas = {6,1,4,3,5};
        int[] cost = {3,8,2,4,2};
        new Solution36().canCompleteCircuit(gas, cost);
    }
}
