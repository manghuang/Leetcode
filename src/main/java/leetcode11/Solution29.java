package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Solution29 {

    //    public int[] sortArrayByParityII(int[] A) {
//        List<Integer> two = new ArrayList<>();
//        List<Integer> one = new ArrayList<>();
//        for (int i = 0; i <A.length ; i++) {
//            if(i % 2 == 0){
//                if(A[i] % 2 == 1){
//                    if(two.isEmpty()){
//                        one.add(i);
//                    }else {
//                        int index = two.get(two.size() - 1);
//                        int temp = A[index];
//                        A[index] = A[i];
//                        A[i] = temp;
//                        two.remove(two.size()-1);
//                    }
//                }
//            }else {
//                if(A[i] % 2 == 0){
//                    if(one.isEmpty()){
//                        two.add(i);
//                    }else {
//                        int index = one.get(one.size()-1);
//                        int temp = A[index];
//                        A[index] = A[i];
//                        A[i] = temp;
//                        one.remove(one.size()-1);
//                    }
//                }
//            }
//        }
//        return A;
//    }
    public int[] sortArrayByParityII(int[] A) {
        List<Integer> two = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                one.add(i);
            }
        }
        for (int i = 1; i < A.length; i += 2) {
            if (A[i] % 2 == 0) {
                two.add(i);
            }
        }
        for (int i = 0; i < one.size(); i++) {
            int oneIndex = one.get(i);
            int twoIndex = two.get(i);
            int temp = A[oneIndex];
            A[oneIndex] = A[twoIndex];
            A[twoIndex] = temp;

        }
        return A;
    }
}
