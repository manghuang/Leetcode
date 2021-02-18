package newyear.leetcode0;

public class Solution1 {

    /*
        滑动窗口法：左指针，右指针，左指针指向当前状态下的第一个0
     */
    public int minKBitFlips(int[] A, int K) {

        int length = A.length;

        int ans = 0;
        int left  =0;
        int right = K;

        while (true){
            while (left < length && A[left] == 1){
                left++;
            }
            if(left == length){
                break;
            }
            right = left + K;
            if(right > length){
                ans = -1;
                break;
            }
            ans++;
            // 需要优化，差分思想，还可以优化
            for (int i = left; i <right ; i++) {
                A[i] = A[i] == 0 ? 1 : 0;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int ans = new Solution1().minKBitFlips(new int[]{1, 0}, 2);
        System.out.println(ans);
    }
}
