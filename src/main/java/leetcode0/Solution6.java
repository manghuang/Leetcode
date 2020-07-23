package leetcode0;

class Solution6 {
    public static void main(String[] args) {
        Solution6 st6 = new Solution6();
        String str = "+";
        System.out.println(st6.myAtoi(str));
    }

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        boolean firstCharNotNumber = true;
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (firstCharNotNumber) {
                if (ch == ' ') {
                    continue;
                } else if ((ch >= '0' && ch <= '9') || ch == '+' || ch == '-') {
                    firstCharNotNumber = false;
                    beginIndex = i;
                    endIndex = i;
                } else {
                    return 0;
                }
            } else {
                if (ch >= '0' && ch <= '9') {
                    endIndex++;
                    continue;
                } else {
                    break;
                }
            }
        }

        if (firstCharNotNumber) {
            return 0;
        }

        char ch = str.charAt(beginIndex);
        double db = 0;
        if (ch == '+') {
            if (beginIndex == endIndex) return 0;
            db = Double.valueOf(str.substring(beginIndex + 1, endIndex + 1));
        } else if (ch == '-') {
            if (beginIndex == endIndex) return 0;
            db = -Double.valueOf(str.substring(beginIndex + 1, endIndex + 1));
        } else {
            db = Double.valueOf(str.substring(beginIndex, endIndex + 1));
        }

        int result = 0;
        if (db > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (db < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        } else {
            result = (int) db;
        }

        return result;
    }
}
