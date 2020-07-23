package leetcode0;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class SoluTion4 {
    public static void main(String[] args) {
        String[] strs = {"time", "me", "bulls"};
        System.out.println(new SoluTion4().minimumLengthEncoding(strs));
    }

    public int minimumLengthEncoding(String[] words) {
        /*
            字符串与字符串的关系：长字符串在前，短字符串在后，相互靠近
                有交集
                    短字符串是长字符串的后缀字串
                    相等
                    部分交集
                无交集
            某个字符串是某个字符串的后缀字串或者相等，才可以合并为一个，其余的均不可以
        */
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            hs.add(words[i]);
        }

        String[] strs = new String[hs.size()];
        int index = 0;
        int endNumber = hs.size();
        for (String str : hs) {
            strs[index++] = str;
            endNumber = endNumber + str.length();
        }

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                int a = strs[i].length();
                int b = strs[j].length();
                if (a == b) continue;
                ;
                if (strs[i].equals(strs[j].substring(b - a, b))) {
                    endNumber = endNumber - 1 - a;
                    break;
                }
            }
        }


        return endNumber;
    }
}
