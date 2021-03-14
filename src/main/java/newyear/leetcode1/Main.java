package newyear.leetcode1;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        while (in.hasNextInt()) {
            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int[][] loca = new int[m][2];
                for (int j = 0; j < m; j++) {
                    loca[j][0] = in.nextInt();
                    loca[j][1] = in.nextInt();
                }
                System.out.println(solve(n, m, loca));
            }
//        }
//        int n = 3;
//        int m = 2;
//        int[][] loca = new int[][]{{2, 1}, {1, 2}};
//        int m = 1;
//        int[][] loca = new int[][]{{2,3}};
//        int n = 5;
//        int m = 4;
////        int[][] loca = new int[][]{{2,3},{3,1},{1,2}};
//        int[][] loca = new int[][]{{4,5},{5,1},{2,2},{3,3}};
//        System.out.println(solve(n, m, loca));
    }

    private static int solve(int n, int m, int[][] loca) {
        HashSet<Integer> isVistedRow = new HashSet<>();
        HashSet<Integer> isVistedCol = new HashSet<>();
        for (int i = 0; i < m; i++) {
            isVistedRow.add(loca[i][0]);
            isVistedCol.add(loca[i][1]);
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            // 如果已经符和要求，不移动
            if (loca[i][0] == loca[i][1]) {
                continue;
            }
            // 如果在对应的行或者列上符合，则移动一下
            if (!isVistedRow.contains(loca[i][1]) || !isVistedCol.contains(loca[i][0])) {
                if (!isVistedRow.contains(loca[i][1])) {
                    isVistedRow.remove(loca[i][0]);
                    isVistedRow.add(loca[i][1]);
                } else {
                    isVistedCol.remove(loca[i][1]);
                    isVistedCol.add(loca[i][0]);
                }
                ans++;
                continue;
            }
            // 如果都不符合，找到一个位置，移动两下
            for (int j = 1; j <= n; j++) { // 1~n个位置
                if (!isVistedRow.contains(j) && !isVistedCol.contains(j)) { // 是否包含第j个点
                    isVistedRow.remove(loca[i][0]);
                    isVistedCol.remove(loca[i][1]);
                    isVistedRow.add(j);
                    isVistedCol.add(j);
                    ans += 2;
                    break;
                }
            }
        }
        return ans;
    }


}
