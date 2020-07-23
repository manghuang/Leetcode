package leetcode0;

public class Soluton7 {
    public static void main(String[] args) {
        Soluton7 s7 = new Soluton7();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = s7.trap(height);
        System.out.println(result);
    }

    public int trap(int[] height) {
        int thisHeight = 0;
        int result = 0;
        int[] temp = new int[height.length];
        while (true) {
            thisHeight++;
            int thisHeightNumber = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] >= thisHeight) {
                    temp[thisHeightNumber++] = i;
                }
            }
            if (thisHeightNumber == 0 || thisHeightNumber == 1) {
                break;
            }
            for (int i = 1; i < thisHeightNumber; i++) {
                result += temp[i] - temp[i - 1] - 1;
            }
        }
        return result;
    }
}
