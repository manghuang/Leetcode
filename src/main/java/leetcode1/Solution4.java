package leetcode1;

import java.util.Arrays;
import java.util.Comparator;

class Solution4 {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 6}};
        a = new Solution4().merge(a);
        for (int[] i :
                a) {
            System.out.println(Arrays.toString(i));
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            int[][] a = {};
            return a;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
//        for (int[] i:
//             intervals) {
//            System.out.println(Arrays.toString(i));
//        }
//        LinkedList<int[]> ll = new LinkedList<>();
        int[][] result = new int[intervals.length][];
        int index = 0;
        for (int[] interval : intervals) {

//            int[] temp = ll.peek();

            if (index == 0) {
//                ll.push(intervals[i]);
                result[index++] = interval;
            } else {
                int[] temp = result[index - 1];
                if (temp[1] >= interval[1]) {
                    continue;
                } else if (temp[1] >= interval[0]) {
                    temp[1] = interval[1];
                } else {
//                    ll.push(intervals[i]);
                    result[index++] = interval;
                }
            }
        }

        result = Arrays.copyOf(result, index);

//        Collections.reverse(ll);
//        int[][] result = new int[ll.size()][];
//        ll.toArray(result);
        return result;
    }
}
