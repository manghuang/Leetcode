package newyear.leetcode0;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // 数组被分割为多个连续为1的子数组，从每个子数组出发，使用k进行连接
    // 延伸分为向左或者向右，如果向左，是在重复以前的讨论，所以要向右
    // 贪心思想，可以连接就一定连接，多种连接分别讨论
    // 因为求的是连续的，所以用滑动窗口
    public int longestOnes(int[] A, int K) {
        int count = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < A.length; i++) {
            if(A[i] == A[i-1]){
                count++;
            }else {
                if(A[i-1] == 0){
                    list.add(-count);
                }else {
                    list.add(count);
                }
                count = 1;
            }
        }
        if(A[A.length-1] == 0){
            list.add(-count);
        }else {
            list.add(count);
        }

        int ans = 0;
        int left = list.get(0) > 0 ? 0 : 1;
        int right = left;
        int temp = 0;
        int remainK = K;
        while (right < list.size()){
            int val = list.get(right);
            if(val > 0){
                temp += val;
                right++;
            }else {
                if(remainK >= -val){
                    remainK += val;
                    temp -= val;
                    right++;
                }else {
                    ans = Math.max(ans, temp+remainK);
                    remainK -= list.get(left+1);
                    temp -= list.get(left);
                    temp += list.get(left+1);
                    left += 2;
                    if(left > right){
                        right = left;
                        temp = 0;
                        remainK = K;
                    }
                }
            }
        }
        ans = Math.max(ans, temp + remainK);
        return Math.min(A.length, ans);
    }

    public static void main(String[] args) {
        int ans = new Solution2().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        System.out.println(ans);
    }


}
