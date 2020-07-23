package leetcode1;

import java.util.Arrays;

class Solution1 {
    public static void main(String[] args) {
        int[] start1 = {1, 0};
        int[] end1 = {1, 1};
        int[] start2 = {-1, 0};
        int[] end2 = {3, 2};
        double[] result = new Solution1().intersection(start1, end1, start2, end2);
        System.out.println(Arrays.toString(result));
    }

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int hy1 = Math.max(start1[1], end1[1]);
        int ly1 = Math.min(start1[1], end1[1]);
        int hy2 = Math.max(start2[1], end2[1]);
        int ly2 = Math.min(start2[1], end2[1]);
        int hx1 = Math.max(start1[0], end1[0]);
        int lx1 = Math.min(start1[0], end1[0]);
        int hx2 = Math.max(start2[0], end2[0]);
        int lx2 = Math.min(start2[0], end2[0]);
        double[] result = {};
        if (start1[0] == end1[0] && start2[0] == end2[0]) {
            if (start1[0] == start2[0]) {
                if (hy1 < ly2 || hy2 < ly1) {

                } else if (ly2 < ly1) {
                    result = new double[2];
                    result[0] = start1[0];
                    result[1] = ly1;
                } else {
                    result = new double[2];
                    result[0] = start1[0];
                    result[1] = ly2;
                }
            }
            return result;
        } else if (start1[0] == end1[0]) {
            return getDoubles(start1, end2, start1, hy1, ly1, hx2, lx2, result, start2[1], start2[0]);
        } else if (start2[0] == end2[0]) {
            return getDoubles(start1, end1, start2, hy2, ly2, hx1, lx1, result, start1[1], start1[0]);
        } else {
            double k1 = (double) (end1[1] - start1[1]) / (end1[0] - start1[0]);
            double b1 = end1[1] - k1 * end1[0];
            double k2 = (double) (end2[1] - start2[1]) / (end2[0] - start2[0]);
            double b2 = end2[1] - k2 * end2[0];
            if (k1 == k2) {
                if (b1 == b2) {
                    if (hx1 < lx2 || hx2 < lx2) {

                    } else if (lx1 < lx2) {
                        result = new double[2];
                        result[0] = lx2;
                        result[1] = k1 * lx2 + b1;
                    } else {
                        result = new double[2];
                        result[0] = lx1;
                        result[1] = k1 * lx1 + b1;
                    }
                }
            } else {
                double tempx = (b2 - b1) / (k1 - k2);
                double tempy = k1 * tempx + b1;
                if (tempx > hx1 || tempx > hx2 || tempx < lx1 || tempx < lx2) {

                } else {
                    result = new double[2];
                    result[0] = tempx;
                    result[1] = tempy;
                }
            }
            return result;
        }

    }

    private double[] getDoubles(int[] start1, int[] end1, int[] start2, int hy2, int ly2, int hx1, int lx1, double[] result, int i, int i2) {
        if (start2[0] >= lx1 && start1[0] <= hx1) {
            double k1 = (double) (end1[1] - i) / (end1[0] - i2);
            double b1 = end1[1] - k1 * end1[0];
            double temp = k1 * start2[0] + b1;
            if (temp >= ly2 && temp <= hy2) {
                result = new double[2];
                result[0] = start2[0];
                result[1] = temp;
            }
        }
        return result;
    }
}
