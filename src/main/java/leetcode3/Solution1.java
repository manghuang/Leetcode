package leetcode3;

public class Solution1 {
    /*
        方法一：公式法，使用乘除法
                (1 + n) * n /2
        方法二：迭代，使用循环关键字
        方法三：递归，使用条件判断关键字或者条件判断语句
     */
    public int sumNums(int n) {
//        return (n+1)*n/2;
        return dps(n);
//        int res = 0;
//        for (int i = 1; i <=n ; i++) {
//            res += i;
//        }
//        return res;
    }

    private int dps(int n) {
        boolean flag = (n > 1) && (n = n + dps(n - 1)) > 0;
        return n;
    }
}
