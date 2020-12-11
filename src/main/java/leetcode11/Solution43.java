package leetcode11;

public class Solution43 {

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0|| matrix[0] == null || matrix[0].length == 0){
            return;
        }
        int length = matrix.length;



        for (int i = 0; i < length/2 ; i++) {
            for (int j = i; j <length-i-1 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-1-j][i];
                matrix[length-1-j][i] =  matrix[length-1-i][length-1-j];
                matrix[length-1-i][length-1-j] = matrix[j][length-1-i];
                matrix[j][length-1-i] = temp;

            }
        }
    }
}
