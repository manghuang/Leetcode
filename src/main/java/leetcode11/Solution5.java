package leetcode11;

import javax.swing.text.MutableAttributeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution5 {

    /*
        dfs,超时
        动态规划：dp[i][j]表示的是{0,i]的clips能否覆盖[0,j]的时间，如果可以覆盖，数字为需要的最小clip数目
                其中，0<= i < clip.length   0<= j <= T
     */
//    private int res = -1;
//    public int videoStitching(int[][] clips, int T) {
//        if(clips == null || clips.length == 0){
//            return -1;
//        }
//        if(T < 0){
//            return -1;
//        }
//        Arrays.sort(clips, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] != o2[0]){
//                    return o1[0] - o2[0];
//                }else {
//                    return o1[1] - o2[1];
//                }
//            }
//        });
//        List<Integer> list = new ArrayList<>();
//        dfs(clips, T, list, 0, 0);
//        return res;
//    }
//
//    private void dfs(int[][] clips, int target, List<Integer> list, int index, int point) {
//        if(point >= target){
//            if(res == -1){
//                res = list.size();
//            }else {
//                res = Math.min(res, list.size());
//            }
//        }
//        if(index >= clips.length){
//            return;
//        }
//        if(clips[index][0] <= point){
//            dfs(clips, target, list, index+1, point);
//            if(clips[index][1] > point){
//                list.add(index);
//                dfs(clips, target, list, index+1, clips[index][1]);
//                list.remove(list.size()-1);
//            }
//        }
//    }

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        int length = clips.length;
        int[][] dps = new int[length][T+1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= T ; j++) {
                if(i == 0){
                    if(clips[i][0] != 0){
                        return -1;
                    }else {
                        if(clips[i][1] >= j){
                            dps[i][j] = 1;
                        }else {
                            dps[i][j] = -1;
                        }
                    }
                }else {
                    if(clips[i][1] >= j){
                        if(clips[i][0] == 0){
                            dps[i][j] = 1;
                        }else if(clips[i][0] >= T) {
                            dps[i][j] = dps[i-1][j];
                        }else {
                            if(dps[i-1][j] == -1){
                                if(dps[i-1][clips[i][0]]== -1){
                                    dps[i][j] = -1;
                                }else {
                                    dps[i][j] = dps[i-1][clips[i][0]]+1;
                                }
                            }else {
                                dps[i][j] = Math.min(dps[i-1][j], dps[i-1][clips[i][0]]+1);
                            }
                        }

                    }else {
                        dps[i][j] = dps[i-1][j];
                    }
                }
            }
        }
        return dps[length-1][T];
    }

    public static void main(String[] args) {
        int[][] clips= {{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};
        int res = new Solution5().videoStitching(clips, 5);
        System.out.println(res);
    }

}
