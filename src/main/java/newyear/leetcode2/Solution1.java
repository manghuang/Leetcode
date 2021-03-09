package newyear.leetcode2;

public class Solution1 {

    public static int resolve(int[] arr, int k ){
        if(arr == null || arr.length == 0 || k <= 0){
            return -1;
        }
        boolean hasFind = false;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i] - arr[i-1] - 1;
            if(k > temp){
                k -= temp;
            }else {
                hasFind = true;
                ans = arr[i-1] + k;
                break;
            }
        }
        if(!hasFind){
            ans = arr[arr.length-1] + k;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = resolve(new int[]{3, 4, 6, 9, 10, 11}, 3);
        System.out.println(ans);
    }
}
