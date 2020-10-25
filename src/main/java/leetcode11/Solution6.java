package leetcode11;

public class Solution6 {

    public int longestMountain(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        int length = A.length;

        int start = 0;
        int mid = 0;
        // true为上升阶段，false为下降阶段
        boolean lift = true;

        int res = 0;
        for (int i = 1; i <length ; i++) {
            if(A[i] > A[i-1]){
                if(!lift){
                    if(start < mid && (i-start) >= 3){
                        res = Math.max(res, i-start);
                    }
                    start = i-1;
                    mid = i-1;
                    lift = true;
                }
            }else if(A[i] == A[i-1]){
                if(!lift){
                    if(mid < (i-1) && (i-start) >= 3){
                        res = Math.max(res, i-start);
                    }
                }
                start = i;
                mid = i;
            }else {
                if(lift){
                   lift = false;
                   mid = i-1;
                }
            }
        }
        if(!lift){
            if(start < mid && (length-start) >= 3){
                res = Math.max(res, length-start);
            }
        }
        return res;
    }
}
