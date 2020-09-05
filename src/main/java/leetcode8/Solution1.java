package leetcode8;

import java.util.LinkedList;

public class Solution1 {

    public static void main(String[] args) {
        String res = new Solution1().getPermutation(3, 2);
        System.out.println(res);
    }

    /*
        迭代
        递归
     */
    public String getPermutation(int n, int k) {
        /*
           下标：     0   1   2   3    ...     n-1
           阶乘：     0!  1!  2!  3!   ...     n-1!
         */
        if (n == 1) {
            return String.valueOf(1);
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums[i] = 0;
            } else if (i == 1) {
                nums[i] = 1;
            } else {
                nums[i] = nums[i - 1] * i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        /*
            下标：     0   1   2     ...   n-1
            数值：     1   2   3     ...   n
         */
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }

        for (int i = n; i >= 1; i--) {
            if (k == 0) {
                for (int j = linkedList.size() - 1; j >= 0; j--) {
                    stringBuilder.append(linkedList.get(j));
                }
                break;
            }
            int temp = k / nums[i - 1];
            k = k % nums[i - 1];
            //从小到大排列，将现存的第temp个数加入StringBuffer
            if (k == 0) {
                temp -= 1;
            }
            stringBuilder.append(linkedList.get(temp));
            linkedList.remove(temp);
        }
        return stringBuilder.toString();
    }

}
