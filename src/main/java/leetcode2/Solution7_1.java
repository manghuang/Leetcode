package leetcode2;

public class Solution7_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        } else if (nums1 == null || nums1.length == 0) {
            int length = nums2.length;
            if (length % 2 == 0) {
                return ((double) nums2[length / 2] + nums2[length / 2 - 1]) / 2;
            } else {
                return nums2[(length - 1) / 2];
            }
        } else if (nums2 == null || nums2.length == 0) {
            int length = nums1.length;
            if (length % 2 == 0) {
                return ((double) nums1[length / 2] + nums1[length / 2 - 1]) / 2;
            } else {
                return (double) nums1[(length - 1) / 2];
            }
        } else {
            int length1 = nums1.length;
            int length2 = nums2.length;
            int count = 0;
            int index1 = 0;
            int index2 = 0;
            /*
              偶数个   1 2 3 4 5 6       4
              奇数给   1 2 3 4 5         3
             */
            int num = (length1 + length2) / 2;
            int midLeftValue = 0;
            int midRightVlaue = 0;
            while (count <= num && index1 < length1 && index2 < length2) {
                if (nums1[index1] <= nums2[index2]) {
                    midLeftValue = midRightVlaue;
                    midRightVlaue = nums1[index1];
                    index1++;
                } else {
                    midLeftValue = midRightVlaue;
                    midRightVlaue = nums2[index2];
                    index2++;
                }
                count++;
            }
            while (count <= num && index1 < length1) {
                midLeftValue = midRightVlaue;
                midRightVlaue = nums1[index1];
                index1++;
                count++;
            }
            while (count <= num && index2 < length2) {
                midLeftValue = midRightVlaue;
                midRightVlaue = nums2[index2];
                index2++;
                count++;
            }
            if ((length1 + length2) % 2 == 0) {
                return (double) (midLeftValue + midRightVlaue) / 2;
            } else {
                return midRightVlaue;
            }
        }
    }


}
