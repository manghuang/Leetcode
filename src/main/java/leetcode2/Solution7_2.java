package leetcode2;

public class Solution7_2 {
    public static void main(String[] args) {
        new Solution7_2().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        /**
         * 如果是偶数，左边和右边相等，指向等分线的右边
         * 如果是奇数，左边比右边多一个，指向分割线的右边
         * 举例子：
         * 偶数个时， 2 3 4 5   length=4  (length+0+1)/2=2   指向4
         * 奇数个时， 2 3 4 5 6    length=5   (length+0+1)/2=3   指向5
         */
        int midIndex = (m + n + 1) / 2;
        int left = 0;
        int right = m;

        while ((left < right)) {
            int i = (right + left + 1) / 2;
            int j = midIndex - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }

        int midRight1 = left;
        int midRight2 = midIndex - midRight1;
        int midLeftValue1 = midRight1 == 0 ? Integer.MIN_VALUE : nums1[midRight1 - 1];
        int midRightValue1 = midRight1 == m ? Integer.MAX_VALUE : nums1[midRight1];
        int midLeftValue2 = midRight2 == 0 ? Integer.MIN_VALUE : nums2[midRight2 - 1];
        int midRightValue2 = midRight2 == n ? Integer.MAX_VALUE : nums2[midRight2];

        if ((m + n) % 2 == 0) {
            return (double) (Math.max(midLeftValue1, midLeftValue2) + Math.min(midRightValue1, midRightValue2)) / 2;
        } else {
            return Math.max(midLeftValue1, midLeftValue2);
        }
    }

}
