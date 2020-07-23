package leetcode0;

public class Solution1 {
    public static void main(String[] args) {
        String str = new Solution1().countAndSay(5);
        System.out.println(str);
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int i = 2; i <= n; i++) {
            String st = sb.toString();
            sb.delete(0, sb.length());
            int count = 1;
            char ch = st.charAt(0);
            for (int j = 0; j < st.length(); j++) {
                if (st.charAt(j) == ch) {

                    if (j != 0) {
                        count++;
                    }

                } else {
                    sb.append(count);
                    sb.append(ch);
                    count = 1;
                    ch = st.charAt(j);
                }
            }
            sb.append(count);
            sb.append(ch);
        }
        String str = sb.toString();
        return str;
    }
}
