package newyear.leetcode3.notebook;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    // 回溯+记忆化搜索
    private  List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {

        if(s == null || s.length() == 0){
            return ans;
        }
        List<String> list = new ArrayList<>();
        dfs(s, 0, list);
        return ans;
    }

    private void dfs(String s, int beginIndex, List<String> list) {
        if(beginIndex >= s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = beginIndex; i <s.length() ; i++) {
            if(isOk(s, beginIndex, i)){
                list.add(s.substring(beginIndex, i+1));
                dfs(s, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isOk(String s, int beginIndex, int endIndex) {
        while (beginIndex <= endIndex){
            if(s.charAt(beginIndex) != s.charAt(endIndex)){
                return false;
            }
            beginIndex++;
            endIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> ans = new Solution5().partition("aab");
        System.out.println(ans);
    }
}
