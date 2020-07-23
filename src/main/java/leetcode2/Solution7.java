package leetcode2;

public class Solution7 {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 2, 2};
        int[] b = {4, 5, 6};
        double res = new Solution7().findMedianSortedArrays(a, b);
        System.out.println(res);
    }

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
            return find(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
        }
    }

    /*
        偶数
            0 1 2 3 4 5
            length:6
            midLeftIndex:(5+0)/2
            midInex:null
            midRightIndex:(5+0)/2+1
        奇数
            0 1 2 3 4
            length:5
            midLeftIndex:(4+0)/2-1
            midIndex:(4+0)/2
            midRightIndex:(4+0)/2+1

     */
    private double find(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2) {
        System.out.println("left1:" + left1);
        System.out.println("right1:" + right1);
        System.out.println("left2:" + left2);
        System.out.println("right2:" + right2);
        System.out.println("______________");
        int length1 = right1 - left1 + 1;
        int length2 = right2 - left2 + 1;

        if (length1 == 1 && length2 == 1) {
            return (double) (nums1[left1] + nums2[left2]) / 2;
        }
        int midLeftIndex1, midRightIndex1;
        int midLeftIndex2, midRightIndex2;
        double midValue1, midValue2;
        if (length1 % 2 == 0) {
            midLeftIndex1 = (right1 + left1) / 2;
            midRightIndex1 = (right1 + left1) / 2 + 1;
            midValue1 = (double) (nums1[midLeftIndex1] + nums1[midRightIndex1]) / 2;
        } else {
            if (length1 == 1) {
                midLeftIndex1 = left1;
                midRightIndex1 = left1;
                midValue1 = nums1[left1];
            } else {
                midLeftIndex1 = (right1 + left1) / 2 - 1;
                midRightIndex1 = (right1 + left1) / 2 + 1;
                midValue1 = nums1[(right1 + left1) / 2];
            }
        }
        if (length2 % 2 == 0) {
            midLeftIndex2 = (right2 + left2) / 2;
            midRightIndex2 = (right2 + left2) / 2 + 1;
            midValue2 = (double) (nums2[midLeftIndex2] + nums2[midRightIndex2]) / 2;
        } else {
            if (length2 == 1) {
                midLeftIndex2 = left2;
                midRightIndex2 = left2;
                midValue2 = nums2[left2];
            } else {
                midLeftIndex2 = (right2 + left2) / 2 - 1;
                midRightIndex2 = (right2 + left2) / 2 + 1;
                midValue2 = nums2[(right2 + left2) / 2];
            }
        }
        if (midValue1 > midValue2) {
            return find(nums1, left1, midLeftIndex1, nums2, midRightIndex2, right2);
        } else if (midValue1 == midValue2) {
            return midValue1;
        } else {
            return find(nums1, midRightIndex1, right1, nums2, left2, midLeftIndex2);
        }
    }

}
