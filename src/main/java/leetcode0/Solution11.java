package leetcode0;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution11 {
    private Map<Statu, Integer> table = new HashMap<>();

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int a = new Solution11().superEggDrop(4, 5000);
        long l1 = System.currentTimeMillis();
        System.out.println(a);
        System.out.println(l1 - l);
    }

    public int superEggDrop(int K, int N) {
        //问的其实是最坏情况下的移动次数（即最小移动次数），鸡蛋数可以用完，也可以不用完。
        //如果鸡蛋数K大于等于lgN，可以使用二分法，答案是lgN，lgN向上取整
        //如果鸡蛋数K小于lgN，则不可以使用二分法，因为这样可能出现鸡蛋用完，楼层还没有确定的情况
        //进一步，可以采用二分法直至剩下最后一个鸡蛋，从确定区间的最底层向最高层移动
        //再进一步，动态规划
        return dp(K, N);

    }

    private int dp(int K, int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        Statu statu = new Statu(K, N);
        if (table.containsKey(statu)) {
            return table.get(statu);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            res = Math.min(res, Math.max(dp(K, N - i), dp(K - 1, i - 1)) + 1);
            // System.out.println(K + "/" + N + "/" + i + "/" + res);
        }
        table.put(statu, res);
        return res;
    }

    class Statu {
        private int K;
        private int N;

        public Statu(int K, int N) {
            this.K = K;
            this.N = N;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Statu statu = (Statu) o;
            return K == statu.K &&
                    N == statu.N;
        }

        @Override
        public int hashCode() {
            return Objects.hash(K, N);
        }
    }
}
