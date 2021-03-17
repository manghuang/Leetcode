package newyear.leetcode3.notebook;

import java.util.*;

public class Solution9 {
    private HashMap<Character, LinkedList<Integer>> table;
    private int ans;
    public int numDistinct(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return 0;
        }
        int sLength  = s.length();
        int tLength = t.length();
        if(sLength < tLength){
            return 0;
        }
        table = new HashMap<>();
        for (int i = 0; i < tLength; i++) {
            char ch = t.charAt(i);
            if(!table.containsKey(ch)){
                table.put(ch, new LinkedList<>());
            }
        }
        for (int i = 0; i < sLength; i++) {
            char ch = s.charAt(i);
            if(table.containsKey(ch)){
                LinkedList<Integer> linkedList = table.get(ch);
                linkedList.offer(i);
                table.put(ch, linkedList);
            }
        }
        dfs(t, 0, -1);
        return ans;
    }

    private boolean dfs(String t, int index, int lastIndex) {
        if(index >= t.length()){
            ans++;
            return true;
        }
        char ch = t.charAt(index);
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> linkedList = table.get(ch);
//        Iterator<Integer> iterator = linkedList.iterator();
        boolean hasOneOrMore = false;
        while (!linkedList.isEmpty()){
//            int next = iterator.next();
//            iterator.remove();
            int next = linkedList.pop();
            stack.push(next);
            if(next > lastIndex){
                if(!dfs(t,index+1, next)){
                    break;
                }else {
                    hasOneOrMore = true;
                }
            }
        }
        while (!stack.isEmpty()){
            linkedList.push(stack.pop());
        }
        return hasOneOrMore;
    }

    public static void main(String[] args) {
        int ans = new Solution9().numDistinct("rabbbit", "rabbit");
        System.out.println(ans);
    }
}
