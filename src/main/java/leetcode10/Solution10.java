package leetcode10;

import java.util.Arrays;
import java.util.Comparator;

public class Solution10 {
    public String arrangeWords(String text) {
        if(text == null){
            return null;
        }

        text = text.trim();
        String[] strs = text.split(" ");

        StringBuilder temp =new StringBuilder(strs[0]);
        temp.setCharAt(0, Character.toLowerCase(temp.charAt(0)));
        strs[0] = temp.toString();

        Arrays.sort(strs, Comparator.comparingInt(String::length));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <strs.length ; i++) {
            if(i==0){
                temp = new StringBuilder(strs[0]);
                temp.setCharAt(0,Character.toUpperCase(temp.charAt(0)));
                res.append(temp.toString());
            }else {
                res.append(" ").append(strs[i]);
            }
        }
        return res.toString();
    }
}
