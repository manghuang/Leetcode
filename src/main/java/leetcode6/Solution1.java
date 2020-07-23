package leetcode6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {


    /*
        方式一：暴力枚举， O(n2)
                存在的问题：重复比较，导致超时
        方式二：思路从小到大排序，逆序对的个数
                排序算法中的稳定排序：
                    冒泡排序 + 索引数组，O(n2)
                    插入排序，O(n2)
                    归并排序 + 索引数组，O(nlgn)
        方式三：二叉搜索树,O(nlgn)
        方式四：树状数组，O(nlgn)
        方式五：线段树，O(nlg(end - start))

     */
    /*
        暴力枚举
     */
//    public List<Integer> countSmaller(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return new ArrayList<>();
//        }
//        int length = nums.length;
//        List<Integer> res = new ArrayList<>();
//        res.add(0);
//        for (int i = length-2; i >=0 ; i--) {
//            int temp  =0;
//            for (int j = i+1; j < length; j++) {
//                if(nums[i] > nums[j]){
//                    temp++;
//                }
//            }
//            res.add(temp);
//        }
//        Collections.reverse(res);
//        return res;
//    }
    /*
        插入排序
           使用ArrayList的尾插法，后反转
           可以直接使用LinkedList的头插法优化
     */
//    public List<Integer> countSmaller(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return new ArrayList<>();
//        }
//        int length = nums.length;
//        List<Integer> res = new ArrayList<>();
//        // 从小到大排序，比较左边比它大的数字，正向插入排序，比较右边比它小的数字，要反向
//        for (int i = length-1; i >= 0 ; i--) {
//            int n = 0;
//            for (int j = i; j <length-1 ; j++) {
//                if(nums[j] > nums[j+1]){
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                    n++;
//                }else {
//                    break;
//                }
//            }
//            res.add(n);
//        }
//        Collections.reverse(res);
//        return res;
//    }
    /*
        冒泡排序+索引数组
     */
//    public List<Integer> countSmaller(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return new ArrayList<>();
//        }
//        int length = nums.length;
//        List<Integer> res = new ArrayList<>();
//        // 从小到大排序
//        int[] index = new int[length];
//        int[] counter = new int[length];
//        for (int i = 0; i <length ; i++) {
//            index[i] = i;
//        }
//        for (int i = 1; i <length; i++) {
//            for (int j = length-1; j >= i; j--) {
//                if(nums[j] < nums[j-1]){
//                    counter[index[j-1]]++;
//                    int temp = nums[j];
//                    nums[j] = nums[j-1];
//                    nums[j-1] = temp;
//                    temp = index[j];
//                    index[j] = index[j-1];
//                    index[j-1] = temp;
//                }
//            }
//        }
//        for (int a:
//             counter) {
//            res.add(a);
//        }
//        return res;
//    }
    /*
            归并排序+索引数组
     */
    private int[] index; //索引数组
    private int[] counter;//记录结果
    private int[] temp;//归并排序需要的额为空间

    public static void main(String[] args) {
        int[] nums = {26, 78, 27, 100, 33, 67, 90, 23, 66, 5, 38, 7, 35, 23, 52, 22, 83, 51, 98, 69, 81, 32,
                78, 28, 94, 13, 2, 97, 3, 76, 99, 51, 9, 21, 84, 66, 65, 36, 100, 41};
        List<Integer> res = new Solution1().countSmaller(nums);
        System.out.println(res);
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int length = nums.length;
        this.index = new int[length];
        this.counter = new int[length];
        this.temp = new int[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
        }
        sortAndMerge(nums, 0, length - 1);
        List<Integer> res = new ArrayList<>();
        for (int a :
                counter) {
            res.add(a);
        }
        return res;
    }

    private void sortAndMerge(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sortAndMerge(nums, left, mid);
        sortAndMerge(nums, mid + 1, right);
        merge(nums, left, mid, right);
        int[] aaa = Arrays.copyOf(index, index.length);
        Arrays.sort(aaa);
        System.out.println(left + "  " + mid + "  " + right + "  " + Arrays.toString(aaa));
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int a = left;
        int b = mid + 1;
        int tempIndex = left;
        while (a <= mid && b <= right) {
            // 正序
            if (nums[a] <= nums[b]) {
                this.index[tempIndex] = a;
                this.temp[tempIndex++] = nums[a++];
            }
            //逆序
            else {
                for (int i = a; i <= mid; i++) {
                    this.counter[index[i]]++;
                }
                this.index[tempIndex] = b;
                this.temp[tempIndex++] = nums[b++];
            }
        }
        while (a <= mid) {
            this.index[tempIndex] = a;
            this.temp[tempIndex++] = nums[a++];
        }
        while (b <= right) {
            this.index[tempIndex] = b;
            this.temp[tempIndex++] = nums[b++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = this.temp[i];
        }
    }
}
