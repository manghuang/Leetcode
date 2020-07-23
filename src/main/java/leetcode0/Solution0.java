package leetcode0;

class Solution0 {
    public static void main(String[] args) {
        String str = new Solution0().reverseWords("the sky   is blue");
        System.out.println(str);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String result = "";

        String[] strs = s.split(" +");
        for (String str : strs) {
            System.out.println(str);
        }


        return result;
    }
}
