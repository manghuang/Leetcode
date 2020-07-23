package leetcode5;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution11 {

    public static void main(String[] args) {
        String[] dic = {"vprkj", "sqvuzjz",
                "ptkrqrkussszzprkqrjrtzzvrkrrrskkrrursqdqpp",
                "spqzqtrqs", "rkktkruzsjkrzqq", "rk", "k",
                "zkvdzqrzpkrukdqrqjzkrqrzzkkrr", "pzpstvqzrzprqkkkd",
                "jvutvjtktqvvdkzujkq", "r", "pspkr", "tdkkktdsrkzpzpuzvszzzzdjj",
                "zk", "pqkjkzpvdpktzskdkvzjkkj", "sr",
                "zqjkzksvkvvrsjrjkkjkztrpuzrqrqvvpkutqkrrqpzu"
        };
        String sen = "rkktkruzsjkrzqqzkvdzqrzpkrukdqrqjzkrqrzzkkrr";
//        for (String str:
//             dic) {
//            System.out.println(str.length());
//        }
//        System.out.println(sen.length());
        int res = new Solution11().respace(dic, sen);
        System.out.println(res);
    }

    /*
        方式一：哈希表+动态规划
        方式二：字典树+动态规划
     */
    public int respace(String[] dictionary, String sentence) {
        HashSet<String> hashSet = new HashSet<>();
        Collections.addAll(hashSet, dictionary);
        int length = sentence.length();
        int[] temp = new int[length + 1];
        Arrays.fill(temp, length);
        temp[0] = 0;
        for (int i = 1; i <= length; i++) {
            temp[i] = temp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                String str = sentence.substring(j, i);
                if (hashSet.contains(str)) {
                    temp[i] = Math.min(temp[i], temp[j]);
                }
            }
        }
        return temp[length];
    }

}
