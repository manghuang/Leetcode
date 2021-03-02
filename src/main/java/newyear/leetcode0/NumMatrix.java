package newyear.leetcode0;

public class NumMatrix {

//    private final int[][] matrix;
//
//    public NumMatrix(int[][] matrix) {
////        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
////            throw new IllegalArgumentException("参数有误");
////        }
//        this.matrix = matrix;
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        if(row1 < 0 || row1 >= matrix.length || col1 < 0 || col1 >= matrix[0].length){
//            return -1;
//        }
//        if(row2 < 0 || row2 >= matrix.length || col2 < 0 || col2 >= matrix[0].length){
//            return -1;
//        }
//        if(row1 > row2 || col1 > col2){
//            return  -1;
//        }
//        int ans = 0;
//        for (int i = row1; i <= row2; i++) {
//            for (int j = col1; j <= col2; j++) {
//                ans += this.matrix[i][j];
//            }
//        }
//        return ans;
//    }
    private final int[][] dp; // 以(0,0)为左上角，当前下标为右下角，内所有元素的和

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            dp = matrix;
        }else{
            dp = new int[matrix.length+1][matrix[0].length + 1];
            for (int i = 1; i <dp.length ; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + matrix[i-1][j-1];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
