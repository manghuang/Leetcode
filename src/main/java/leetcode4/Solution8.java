package leetcode4;

import java.util.Objects;

public class Solution8 {

    public static void main(String[] args) {
        String value = "thuhrh";
        String pattern = "bb";
        boolean res = new Solution8().patternMatching(pattern, value);
        System.out.println(res);
    }

    /*
        思路：进行匹配，是否有a和b存在，如果有，找出所有可能的a和b的值，判断是否相等，如果有至少有一个不等，就返回true
        aNum * aLength + bNum * bLength = vLength
        aLength = (vLength - bNum * bLength) / aNum
    */
    public boolean patternMatching(String pattern, String value) {
        int vLength = value.length();
        int pLength = pattern.length();
        if (vLength == 0) {
            if (pLength == 0 || pLength == 1) {
                return true;
            } else return !pattern.contains("a") || !pattern.contains("b");
        } else {
            if (pLength == 0) {
                return false;
            } else if (pLength == 1) {
                return true;
            }
        }

        int aNum = 0;
        for (int i = 0; i < pLength; i++) {
            if (pattern.charAt(i) == 'a') {
                aNum++;
            }
        }
        int bNum = pLength - aNum;

        if (aNum == 0) {
            return isOk(value, bNum);
        } else if (bNum == 0) {
            return isOk(value, aNum);
        } else {
            int bLength = 0;
            while (true) {
                int temp = vLength - bNum * bLength;
                if (temp < 0) {
                    break;
                }
                if (temp % aNum != 0) {
                    bLength++;
                    continue;
                }
                int aLength = temp / aNum;

                int aFirstIndex = pattern.indexOf("a");
                int bFirstIndex = pattern.indexOf("b");
                String aStr = value.substring(aFirstIndex * bLength, aFirstIndex * bLength + aLength);
                String bStr = value.substring(bFirstIndex * aLength, bFirstIndex * aLength + bLength);
                if (!Objects.equals(aStr, bStr)) {
                    if (isok2(value, aStr, bStr, pattern)) {
                        return true;
                    }
                }
                bLength++;
            }
        }
        return false;
    }

    private boolean isok2(String value, String aStr, String bStr, String pattern) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                stringBuilder.append(aStr);
            } else {
                stringBuilder.append(bStr);
            }
        }
        return stringBuilder.toString().equals(value);
    }

    private boolean isOk(String value, int num) {
        if (value.length() % num != 0) {
            return false;
        }
        int length = value.length() / num;
        String str = value.substring(0, length);
        String res = value.replace(str, "");
        return Objects.equals(res, "");
    }
}
