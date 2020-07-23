package leetcode2;


import java.util.Arrays;
import java.util.LinkedList;

public class Solution12 {
    public static void main(String[] args) {
        int[] a = new int[]{1};
        int res = new Solution12().largestRectangleArea(a);
        System.out.println(res);
    }

    /*
     * 暴力枚举 O(n2)
     * 左右双指针  O(n),用在直方图蓄水时候
     * 直方图求最大长方形面积   左右单调栈
     */
//    public int largestRectangleArea(int[] heights) {
//        if(heights == null){
//            return 0;
//        }
//        int len = heights.length;
//        int res = 0;
//        for (int i = 0; i <len ; i++) {
//            int count = 1;
//            int front = i-1;
//            int behind = i+1;
//            while (front>=0 && heights[front] >= heights[i]){
//                count++;
//                front--;
//            }
//            while (behind <len && heights[behind] >= heights[i]){
//                count++;
//                behind++;
//            }
//            int temp = count*heights[i];
//            res = Math.max(temp, res);
//        }
//        return res;
//    }
    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        int res = 0;
        int[] leftIndex = new int[len];
        int[] rightIndex = new int[len];
        Arrays.fill(rightIndex, len);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                rightIndex[stack.peek()] = i;
                stack.pop();
            }
            leftIndex[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
//        stack.clear();
//        for (int i = len-1; i >=0 ; i--) {
//            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
//                stack.pop();
//            }
//            rightIndex[i] = stack.isEmpty()?len:stack.peek();
//            stack.push(i);
//        }
        System.out.println(Arrays.toString(leftIndex));
        System.out.println(Arrays.toString(rightIndex));
        for (int i = 0; i < len; i++) {
            res = Math.max(res, heights[i] * (rightIndex[i] - leftIndex[i] - 1));
        }
        return res;
    }
}
