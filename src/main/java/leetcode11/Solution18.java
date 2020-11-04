package leetcode11;

public class Solution18 {

    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3){
            return false;
        }
        boolean up = true;
        for (int i = 1; i <A.length ; i++) {
            if(up){
                if(A[i] > A[i-1]){
                    continue;
                }else if(A[i] == A[i-1]){
                    return false;
                }else {
                    if(i == 1){
                        return false;
                    }else {
                        up = false;
                    }
                }
            }else {
                if(A[i] >= A[i-1]){
                    return false;
                }
            }
        }
        return !up;
    }
}
