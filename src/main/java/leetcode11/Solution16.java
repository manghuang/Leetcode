package leetcode11;

import java.util.*;

public class Solution16 {

//    private List<String> res = new ArrayList<>();
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
//            return res;
//        }
//        Map<Character, Set<String>> map = new HashMap<>();
//        for (String temp : wordDict) {
//            char ch = temp.charAt(0);
//            if (!map.containsKey(ch)) {
//                Set<String> set = new HashSet<>();
//                set.add(temp);
//                map.put(ch, set);
//            } else {
//                Set<String> set = map.get(ch);
//                set.add(temp);
//            }
//        }
//        dfs(s, 0, map, new StringBuilder());
//        return res;
//    }
//
//    private void dfs(String s, int index, Map<Character, Set<String>> map, StringBuilder stringBuilder) {
//        if(index == s.length()){
//            res.add(stringBuilder.toString());
//            return;
//        }
//        char ch = s.charAt(index);
//        if(map.containsKey(ch)){
//            Set<String> set = map.get(ch);
//            for (String next : set) {
//                int endIndex = index + next.length();
//                if (endIndex <= s.length()) {
//                    if (s.substring(index, endIndex).equals(next)) {
//                        if(index != 0){
//                            stringBuilder.append(" ");
//                        }
//                        stringBuilder.append(next);
//                        dfs(s, endIndex, map, stringBuilder);
//                        stringBuilder.delete(stringBuilder.length() - next.length(), stringBuilder.length());
//                        if(index != 0){
//                            stringBuilder.deleteCharAt(stringBuilder.length()-1);
//                        }
//                    }
//                }
//            }
//        }
//    }
    private Map<Integer, List<String>> dp = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0){
            return new ArrayList<>();
        }
        // 可以用字典树代替map
        Map<Character, Set<String>> map = new HashMap<>();
        for (String temp : wordDict) {
            char ch = temp.charAt(0);
            if (!map.containsKey(ch)) {
                Set<String> set = new HashSet<>();
                set.add(temp);
                map.put(ch, set);
            } else {
                Set<String> set = map.get(ch);
                set.add(temp);
            }
        }
        return dfs(s, 0, map);

    }

    private List<String> dfs(String s, int index, Map<Character, Set<String>> map) {
        List<String> res = new ArrayList<>();
        if(index == s.length()){
            return res;
        }
        if(dp.containsKey(index)){
            return dp.get(index);
        }else {
            char ch = s.charAt(index);
            if(map.containsKey(ch)){
                Set<String> set = map.get(ch);
                for (String next : set) {
                    int endIndex = index + next.length();
                    if (endIndex <= s.length()) {
                        if (s.substring(index, endIndex).equals(next)) {
                            List<String> list = dfs(s, endIndex, map);
                            if(!list.isEmpty()){
                                for (String str: list
                                     ) {
                                    res.add(next + " " + str);
                                }
                            }else {
                                if(endIndex == s.length()){
                                    res.add(next);
                                }
                            }
                        }
                    }
                }
            }
            dp.put(index, res);
            return res;
        }
    }

}
