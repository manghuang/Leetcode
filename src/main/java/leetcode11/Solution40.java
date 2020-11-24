package leetcode11;

import java.util.Arrays;
import java.util.Comparator;

public class Solution40 {

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0] == null || points[0].length != 2){
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] <= o2[1] ? -1 : 1;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        int num = 1;
        int left = points[0][0];
        int right = points[0][1];
        for (int i = 1; i <points.length ; i++) {
            if(points[i][0] > right){
                num++;
                left = points[i][0];
                right = points[i][1];
            }else {
                left = points[i][0];
                right = Math.min(right, points[i][1]);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        int res = new Solution40().findMinArrowShots(a);
        System.out.println(res);
    }
}
