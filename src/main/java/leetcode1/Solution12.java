package leetcode1;

public class Solution12 {
    public static void main(String[] args) {
        /**
         * 1
         * 12
         * a=6  c=1  6+31=37
         * a=2  c=3  6+1 = 7    3+8 = 11
         */
        int a = new Solution12().waysToChange(900750);
        System.out.println(a);
    }

    public int waysToChange(int n) {
        double temp = 0;

        if (n >= 1) {
            temp++;
        }
        if (n >= 5) {
            temp += n / 5;
        }

        if (n >= 10) {
            temp += haveTen(n);
        }

        if (n >= 25) {
            int a = n / 25;
            int b = n % 25;
            int c;

            if (b >= 20) {
                c = 5;
            } else if (b >= 15) {
                c = 4;
            } else if (b >= 10) {
                c = 3;
            } else if (b >= 5) {
                c = 2;
            } else {
                c = 1;
            }
            temp += (c * a + 5 * (double) a * (a - 1) / 2) % 1000000007;
            for (int i = a; i >= 1; i--) {
                temp += haveTen(b + (a - i) * 25);
            }
        }

        return (int) (temp % 1000000007);
    }

    private double haveTen(int i) {
        double a = i / 10;
        int b = i % 10;
        int c;
        if (b >= 5) {
            c = 2;
        } else {
            c = 1;
        }
        return (c * a + a * (a - 1)) % 1000000007;
    }
}
