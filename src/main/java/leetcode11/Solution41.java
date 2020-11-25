package leetcode11;

import java.util.*;

public class Solution41 {

    public String sortString(String s) {
        if(s == null){
            return s;
        }
        int[] table = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            table[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index<s.length()){
            for (int i = 0; i <table.length ; i++) {
                if(table[i] > 0){
                    index++;
                    res.append((char) (i + 'a'));
                    table[i]--;
                }
            }
            for (int i = table.length-1; i >= 0 ; i--) {
                if(table[i] > 0){
                    index++;
                    res.append((char) (i + 'a'));
                    table[i]--;
                }
            }
        }
        return res.toString();
    }
}
