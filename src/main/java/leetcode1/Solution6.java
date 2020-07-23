package leetcode1;

public class Solution6 {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 18, 17, 6};
        int b = new Solution6().maxArea(a);
        System.out.println(b);
    }

    public int maxArea(int[] height) {
        int result = 0;
//        for(int i=0; i<height.length; i++){
//            for(int j=i+1; j<height.length; j++){
//                int a = Math.min(height[i], height[j]) * (j-i);
//                if(a>result){
//                    result = a;
//                }
//            }
//        }

        int left = 0;
        int right = height.length - 1;
        result = Math.min(height[right], height[left]) * (right - left);
        while (left < right) {
            if (height[left] <= height[right]) {
                int leftTemp = left;
                while (height[++leftTemp] <= height[left] && leftTemp < right) {
                }
                if (leftTemp < right) {
                    int a = Math.min(height[leftTemp], height[right]) * (right - leftTemp);
                    if (a > result) {
                        result = a;
                    }
                }
                left = leftTemp;

            } else {
                int righrTemp = right;
                while (height[--righrTemp] <= height[right] && left < righrTemp) {
                }
                if (left < righrTemp) {
                    int a = Math.min(height[left], height[righrTemp]) * (righrTemp - left);
                    if (a > result) {
                        result = a;
                    }
                }
                right = righrTemp;
            }
        }
        return result;
    }
}
