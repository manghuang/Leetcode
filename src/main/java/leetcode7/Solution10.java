package leetcode7;

import java.util.ArrayList;
import java.util.List;

public class Solution10 {
    /*
        分析：直接dps
        回溯，指的是dps，进入下一层时候要添加限制，不满足或满足返回上层时候要恢复现场（去掉添加的限制）。
        因为这里在判断是否冲突的时候没有采用集合，所以不需要回溯，直接dps

        bps

        dps（返回值类型为void或者其他类型）
        回溯(基于dps)
        分支定界（收紧范围）

        dps+返回值不是void的情况下, 可以加状态数组优化，进而采用动态规划
     */
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }
        this.res = new ArrayList<>();
        int[] map = new int[n];
        dps(map, 0, n);
        return this.res;
    }

    private void dps(int[] map, int index, int n) {
        if (index >= n) {
            List<String> list = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            for (int num : map
            ) {
                for (int i = 0; i < num; i++) {
                    stringBuffer.append('.');
                }
                stringBuffer.append('Q');
                for (int i = num + 1; i < n; i++) {
                    stringBuffer.append('.');
                }
                list.add(stringBuffer.toString());
                stringBuffer.delete(0, n);
            }
            this.res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isOk(map, index, i)) {
                map[index] = i;
                dps(map, index + 1, n);
            }
        }
    }

    private boolean isOk(int[] map, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (y == map[i]) {
                return false;
            }
            if (Math.abs(x - i) == Math.abs(y - map[i])) {
                return false;
            }
        }
        return true;
    }
}
