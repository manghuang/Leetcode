package leetcode7;

import java.util.ArrayList;

public class Solution5 {

    /*
        思路：一个状态到一个状态，在状态转移时候，移除颜色连续相同的盒子（最大数量）
        方法一：模拟：dps
        方法二：动态规划
        算法：
            宏观：
            具体实现：
        数据结构：
     */
    private int ans;

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        int res = new Solution5().removeBoxes(a);
        System.out.println(res);
    }

    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }
        boolean[] isRemoved = new boolean[boxes.length];
        dps(boxes, isRemoved, 0, 0);
        return this.ans;
    }

    private void dps(int[] boxes, boolean[] isRemoved, int res, int num) {
        int length = boxes.length;
        if (num == length) {
            ans = Math.max(ans, res);
            return;
        }
        int firstColor = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (isRemoved[i]) {
                continue;
            }
            if (arrayList.isEmpty()) {
                firstColor = boxes[i];
                arrayList.add(i);
            } else {
                if (boxes[i] == firstColor) {
                    arrayList.add(i);
                } else {
                    // 修改isRemoced
                    for (int a : arrayList
                    ) {
                        isRemoved[a] = true;
                    }
                    int tempNum = arrayList.size();
                    dps(boxes, isRemoved, res + tempNum * tempNum, num + tempNum);
                    // 将isRemoved返回修改前的状态
                    for (int a : arrayList
                    ) {
                        isRemoved[a] = false;
                    }
                    firstColor = boxes[i];
                    arrayList.clear();
                    arrayList.add(i);
                }
            }
            if (!arrayList.isEmpty()) {
                // 修改isRemoced
                for (int a : arrayList
                ) {
                    isRemoved[a] = true;
                }
                int tempNum = arrayList.size();
                dps(boxes, isRemoved, res + tempNum * tempNum, num + tempNum);
                // 将isRemoved返回修改前的状态
                for (int a : arrayList
                ) {
                    isRemoved[a] = false;
                }
            }
        }

    }

}
