package leetcode4;

public class Solution3 {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean res = new Solution3().isPalindrome(str);
        System.out.println(res);
    }

    /*
        方式一：转小写，左右指针遍历比较
        方式二：正则表达式去除其他字符，从中间对折后忽略大小写比较
     */
//    public boolean isPalindrome(String s) {
//        if(s == null){
//            return false;
//        }
//        int length = s.length();
//        if(length == 0 || length == 1){
//            return true;
//        }
//        s = s.toLowerCase();
//        int left = 0;
//        int right = length-1;
//        while (left < right){
//            char leftch = s. charAt(left);
//            while (left < right && (leftch< '0' || (leftch > '9' &&  leftch < 'a') || leftch > 'z')){
//                left++;
//                leftch = s.charAt(left);
//            }
//            char rightch = s. charAt(right);
//            while (left < right && (rightch< '0' || (rightch > '9' && rightch < 'a') || rightch > 'z')){
//                right--;
//                rightch = s.charAt(right);
//            }
//            if(leftch != rightch){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length == 0 || length == 1) {
            return true;
        }
//        System.out.println(s);
        String regEX = "[^0-9a-zA-Z]";
        s = s.replaceAll(regEX, "");
        length = s.length();
//        System.out.println(s);
        String str1;
        String str2;
        if (length % 2 == 0) {
            str1 = s.substring(0, length / 2);
            str2 = s.substring(length / 2, length);
        } else {
            str1 = s.substring(0, (length - 1) / 2);
            str2 = s.substring((length + 1) / 2, length);
        }
        str2 = new StringBuilder(str2).reverse().toString();
        return str1.equalsIgnoreCase(str2);
    }
}
