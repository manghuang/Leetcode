package leetcode5;

import java.io.*;

public class Solution4 {

    public static void main(String[] args) {
        String str = "";
        try {
            File file = new File("src\\main\\java\\leetcode5\\1.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(str);

        String res = new Solution4().shortestPalindrome(str);
        System.out.println(res);
    }

    /*
        begin=0, end在[1,s.length]之间，枚举所有字符子串，判断是不是回文串
     */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = length - 1; i >= 0; i--) {
            if (isHuiWen(chars, 0, i)) {
                StringBuilder stringBuilder = new StringBuilder(s.substring(i + 1, s.length()));
                res = stringBuilder.reverse().toString() + s;
                break;
            }
        }
        return res;
    }

//    private boolean isHuiWen(String str) {
//        int begin = 0;
//        int end = str.length()-1;
//        while (begin<end){
//            if(str.charAt(begin) != str.charAt(end)){
//                return false;
//            }
//            begin++;
//            end--;
//        }
//        return true;
//    }

    private boolean isHuiWen(char[] chars, int begin, int end) {
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

}
