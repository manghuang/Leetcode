package leetcode5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {

    //    public int kthSmallest(int[][] matrix, int k) {
//        int length = matrix.length;
//        int[] columns = new int[length];
//        int res = 0;
//        for (int i = 0; i < k; i++) {
//            int temp = -1;
//            for (int j = 0; j < length; j++) {
//                if (temp == -1 && columns[j] < length) {
//                    temp = j;
//                }
//                if (columns[j] < length) {
//                    if (matrix[j][columns[j]] < matrix[temp][columns[temp]]) {
//                        temp = j;
//                    }
//                }
//            }
//            res = matrix[temp][columns[temp]];
//            columns[temp]++;
//        }
//        return res;
//    }
    public static void main(String[] args) {
        int[][] martix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int k = 20;
        int res = new Solution2().kthSmallest(martix, k);
        System.out.println(res);
    }

    /*
        方式一：转换为一维数组，排序
        方式二：归并排序--自己实现，存在重复比较
        方式三、归并排序改进--优先级队列、最小堆
        方式四、利用列有序--自己实现，存在重复比较
        方式五、利用列有序--二分查找，逼近
     */
//    public int kthSmallest(int[][] matrix, int k) {
//        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
//            return 0;
//        }
//        int length = matrix.length;
//
//        int[] indexs = new int[length];
//        int index = 0;
//        int countNum = 0;
//        int res = 0;
//
//        while (index < length){
//            int temp = matrix[index][indexs[index]];
//            int tempIndex = index;
//
//            for(int i=index+1; i<length; i++){
//                if(indexs[i] >= indexs[i-1]){
//                    continue;
//                }
//                if(matrix[i][indexs[i]] < temp){
//                    temp = matrix[i][indexs[i]];
//                    tempIndex = i;
//                }
//            }
//            System.out.println(temp);
//            indexs[tempIndex]++;
//            countNum++;
//            if(countNum == k){
//                res = temp;
//                break;
//            }else {
//                if(indexs[index] >= length){
//                    index++;
//                }
//            }
//        }
//        return res;
//    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

}
