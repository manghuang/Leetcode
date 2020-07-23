package leetcode1;

public class Solution11 {
    public int waysToChange(int n) {
        long temp = 0;

        if (n >= 1) {
            temp++;
        }
        if (n >= 5) {
            temp += n / 5;
        }
        /**
         * a    c
         * a-1  c+2
         * a-2  c+2+2
         * a-3  c+2+2+2
         * ...  ...
         * 1    c+2*(a-1)
         *
         * c*a+2*((a)*(a-1)/2) = c*a +a*(a-1)
         *
         */
        if (n >= 10) {
            temp += haveTen(n);
        }
        /**
         * 10 10 5
         * 10 10 1...
         * 10 5 5 5
         * 10 5 5 1...
         * 10 5 1...
         * 10 1...
         * 5 5 5 5 5
         * 5 5 5 5 1...
         * 5 5 5 1...
         * 5 5 1...
         * 5 1...
         * 1...
         *
         * a     c             d
         * a-1   c+5           d+2
         * a-2   c+5+5         d+5
         * a-3   c+5+5+5       d+7
         * ...   ...
         * 1     c+5*(a-1)
         *
         * c*a+5*((a) * (a-1/2))
         */
        if (n >= 25) {
            int a = n / 25;
            int b = n % 25;
            int c;
            /**
             * 10 10  1...
             * 10 5 5 1...
             * 10 5 1...
             * 10 1...
             * 5 5 5 5 1...
             * 5 5 5 1...
             * 5 5 1...
             * 5 1...
             * 1...
             */
            if (b >= 20) {
                c = 5;
            }
            /**
             * 10 5 1...
             * 10 1...
             * 5 5 5 1...
             * 5 5 1..
             * 5 1..
             * 1...
             */
            else if (b >= 15) {
                c = 4;
            }
            /**
             * 10 1...
             * 5 5 1...
             * 5 1...
             * 1...
             */
            else if (b >= 10) {
                c = 3;
            }
            /**
             * 5 1...
             * 1...
             */
            else if (b >= 5) {
                c = 2;
            }
            /**
             * 1...
             */
            else {
                c = 1;
            }
            temp += c * a + (Math.pow(5, a - 1) - 1) / 4 - 1;
            for (int i = a; i >= 1; i--) {
                temp += haveTen(b + (a - i) * 25);
            }
        }

        return (int) (temp % 1000000007);
    }

    private long haveTen(int i) {
        int a = i / 10;
        int b = i % 10;
        int c;
        if (b >= 5) {
            c = 2;
        } else {
            c = 1;
        }
        return (long) (c * a + Math.pow(2, a - 1) - 2);
    }
}
