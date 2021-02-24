package newyear.leetcode0;

public class Solution7 {

    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0 || A[0] == null || A[0].length == 0){
            return new int[0][0];
        }
        int xLength = A.length;
        int yLength = A[0].length;

        for (int i = 0; i < xLength; i++) {
            int left = 0;
            int right = yLength-1;
            while (left < right){

                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;

                A[i][left] ^= 1;
                A[i][right] ^= 1;

                left++;
                right--;
            }
            if(left == right){
                A[i][left] ^= 1;
            }
        }
        return A;
    }
}
