package leetcode7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution9 {

    public static void main(String[] args) {
        String str = "1.";
        boolean res = new Solution9().isNumber(str);
        System.out.println(res);
//        String[] es = str.split("e",2);
//        System.out.println(es.length);
//        for (int i = 0; i <es.length ; i++) {
//            System.out.println(es[i]);
//        }
    }

    /*
        数值：

            直接表示  小数或者整数
            科学计数法表示  按e分开两部分，前面可以是整数或者小数，后面只能是小数

     */
    /*
        特殊字符：
            +/-
            .
            e/E
            0-9
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //  分类讨论
        // 使用正则表达式
        int[] table = new int[4];
        s = s.trim();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                table[0]++;
            } else if (ch == 'E') {
                table[1]++;
            } else if (ch == 'e') {
                table[2]++;
            } else if (ch == '.') {
                table[3]++;
            } else if ((ch >= '0' && ch <= '9')) {
                continue;
            } else {
                return false;
            }
        }
        int temp = table[1] + table[2];
        if (temp == 0) {
            return isZhenShu(s) || isXiaoShu(s);
        } else if (temp == 1) {
            String[] es;
            if (table[1] == 1) {
                es = s.split("E", 2);
            } else {
                es = s.split("e", 2);
            }
            return (isZhenShu(es[0]) || isXiaoShu(es[0])) && isZhenShu(es[1]);
        } else {
            return false;
        }
    }

    private boolean isXiaoShu(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Pattern pattern = Pattern.compile("([+-]?\\d*[.]\\d+)|([+-]?\\d+[.]\\d*)");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private boolean isZhenShu(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Pattern pattern = Pattern.compile("[+-]?\\d+");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

}
