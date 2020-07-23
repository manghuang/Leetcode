package leetcode1;

public class Solution13 {
    private int result;

    public static void main(String[] args) {
        int a[] = {4, 3, 2, 1};
        int b = new Solution13().reversePairs(a);
        System.out.println(b);
    }

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return result;
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//        int len = nums.length;
//        int result = 0;
//        for(int i=0; i<len; i++){
//            for(int j=i+1; j<len; j++){
//                if(nums[i] > nums[j]){
//                    result++;
//                }
//            }
//        }
//        return  result;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                this.result += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, k);
    }
}
