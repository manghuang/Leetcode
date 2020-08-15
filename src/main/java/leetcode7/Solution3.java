package leetcode7;

import java.math.BigInteger;

public class Solution3 {

    /*
          思路一：字符串转数字
                    转int类型，溢出
                    考虑到范围转doublel类型，精度不够，有小数
          方式一：使用BigInteger大数类型
          方式二：使用数组
          方式三：模拟竖乘

     */
//    public String multiply(String num1, String num2) {
//        double one = Double.parseDouble(num1);
//        double two = Double.parseDouble(num2);
//        return Double.toString(one * two);
//    }
    public String multiply(String num1, String num2) {
        BigInteger one = new BigInteger(num1);
        BigInteger two = new BigInteger(num2);
        BigInteger res = one.multiply(two);
        return res.toString();
    }

}
