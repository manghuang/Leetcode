package leetcode2;

public class Solution2 {
    private int head;
    private int tail;

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgml" +
                "cupuufxoohdfpgjdmysgvhmvffcnqxj" +
                "jxqncffvmhvgsymdjgpfdhooxfuupucu" +
                "lmgmqfvnbgtapekouga";
        String s2 = "cupuufxoohdfpgjdmysgvhmvffcnqxj" +
                "jxqncffvmhvgsymdjgpfdhooxfuupucu";
        System.out.println(new Solution2().validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }

        this.head = 0;
        this.tail = s.length() - 1;
        if (isHuiWen(s)) {
            return true;
        } else {
            boolean b1 = s.charAt(this.head + 1) == s.charAt(this.tail);
            boolean b2 = s.charAt(this.head) == s.charAt(this.tail - 1);
            if (b1 && b2) {
                int a = this.head;
                int b = this.tail;
                this.head = a + 1;
                if (isHuiWen(s)) {
                    return true;
                } else {
                    this.head = a;
                    this.tail = b - 1;
                    return isHuiWen(s);
                }
            } else if (b1) {
                this.head++;
                return isHuiWen(s);
            } else if (b2) {
                this.tail--;
                return isHuiWen(s);
            } else {
                return false;
            }
        }
    }

    private boolean isHuiWen(String s) {
        while (this.head < this.tail) {
            if (s.charAt(this.head) != s.charAt(this.tail)) {
                return false;
            } else {
                this.head++;
                this.tail--;
            }
        }
        return true;
    }
}
