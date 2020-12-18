package leetcode14;

public class Solution4 {

    public int countEval(String s, int result) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        int numLength = length / 2;
        int[][][] dp = new int[numLength+1][numLength+1][2];
        for(int i=0; i<= numLength; i++){
            int index = 2 *i;
            if(s.charAt(index) == '0'){
                dp[i][i][0] = 1;
            }else if(s.charAt(index) == '1'){
                dp[i][i][1] = 1;
            }else{
                return -1;
            }
        }
        for(int r=1; r <= numLength; r++){
            for(int i=0; i <= numLength-r; i++){
                int j=i+r;
                for(int k=0; k<r; k++){
                    int x = i+k;
                    int y = i+k+1;
                    char ch = s.charAt(2*x + 1);
                    if(dp[i][x][0] != 0){
                        if(dp[y][j][0] != 0){
                            if(ch == '&'){
                                dp[i][j][0] += dp[i][x][0] * dp[y][j][0];
                            }else if(ch == '|'){
                                dp[i][j][0] += dp[i][x][0] * dp[y][j][0];
                            }else{
                                dp[i][j][0] += dp[i][x][0] * dp[y][j][0];
                            }
                        }
                        if(dp[y][j][1] != 0){
                            method(dp, i, j, x, y, ch, 0, 1);
                        }
                    }
                    if(dp[i][x][1] != 0){
                        if(dp[y][j][0] != 0){
                            method(dp, i, j, x, y, ch, 1, 0);
                        }
                        if(dp[y][j][1] != 0){
                            if(ch == '&'){
                                dp[i][j][1] += dp[i][x][1] * dp[y][j][1];
                            }else if(ch == '|'){
                                dp[i][j][1] += dp[i][x][1] * dp[y][j][1];
                            }else{
                                dp[i][j][0] += dp[i][x][1] * dp[y][j][1];
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<=numLength; i++){
            for (int j = 0; j <= numLength ; j++) {
                System.out.print(dp[i][j][0] + "|"  + dp[i][j][1] + "   ");
            }
            System.out.println();
        }
        return dp[0][numLength][result];
    }

    private void method(int[][][] dp, int i, int j, int x, int y, char ch, int i2, int i3) {
        if(ch == '&'){
            dp[i][j][0] += dp[i][x][i2] * dp[y][j][i3];
        }else if(ch == '|'){
            dp[i][j][1] += dp[i][x][i2] * dp[y][j][i3];
        }else{
            dp[i][j][1] += dp[i][x][i2] * dp[y][j][i3];
        }
    }

    public static void main(String[] args) {
        int res = new Solution4().countEval("0&0&0&1^1|0", 1);
        System.out.println(res);
    }
}
