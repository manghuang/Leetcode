package leetcode11;

import java.util.Arrays;

public class Solution41 {

    public double knightProbability(int N, int K, int r, int c) {
        if(K == 0){
            return 1;
        }
        double[][][] dp = new double[K+1][N][N];
        dp[0][r][c] = 1.0;
        int[] X = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        int[] Y = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        for(int round = 1; round <= K ; round++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    for(int m = 0; m < 8; m++){
                        int lastX = i + X[m];
                        int lastY = j + Y[m];
                        if(lastX < N && lastX >= 0 && lastY < N && lastY >= 0){
                            dp[round][i][j] +=   0.125 * dp[round-1][lastX][lastY];
                        }
                    }
                }
            }
        }
        double res = 0.0;
        for(int i=0; i< N; i++){
            for(int j=0; j<N; j++){
                res += dp[K][i][j];
            }
        }
        return res;
    }
}
