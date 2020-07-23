package leetcode4;

public class Solution9 {

    /*
        方式一、字符串转二进制int，在转十进制int，相加，转二进制int，转字符串
                限制：字符串的长度要<=21
        方式二、在字符串上操作，分情况讨论
                无限制
     */
//    public String addBinary(String a, String b) {
//        int aNum = Integer.parseUnsignedInt(a, 2);
//        int bNum = Integer.parseUnsignedInt(b, 2);
////        System.out.println(aNum);
////        System.out.println(bNum);
//        int resNum = aNum + bNum;
//        String resStr = Integer.toString(resNum, 2);
////        System.out.println(resStr);
//        return resStr;
//    }

    public static void main(String[] args) {
        String a = "101111";
        String b = "10";
        //      110001
        String res = new Solution9().addBinary(a, b);
        System.out.println(res);
    }

    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int c = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            int aNum = a.charAt(aIndex) - '0';
            int bNum = b.charAt(bIndex) - '0';
            int sum = aNum + bNum + c;
            c = sum / 2;
            res.append(Integer.toString(sum % 2));
            aIndex--;
            bIndex--;
        }
        while (aIndex >= 0) {
            int aNum = a.charAt(aIndex) - '0';
            int sum = aNum + c;
            c = sum / 2;
            res.append(Integer.toString(sum % 2));
            aIndex--;
        }
        while (bIndex >= 0) {
            int bNum = b.charAt(bIndex) - '0';
            int sum = bNum + c;
            c = (bNum + c) / 2;
            res.append(Integer.toString(sum % 2));
            bIndex--;
        }
        if (c == 1) {
            res.append(Integer.toString(c));
        }
        return res.reverse().toString();
    }

}
