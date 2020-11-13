package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Solution31 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        if(n <= 0){
            return res;
        }
        StringBuilder stringBuilder = new StringBuilder();
        dfs(stringBuilder, n ,n);
        return res;
    }

    private void dfs(StringBuilder stringBuilder, int left, int right) {
        if(left == 0 && right == 0){
            res.add(stringBuilder.toString());
            return;
        }
        if(left > 0){
            stringBuilder.append('(');
            dfs(stringBuilder, left-1, right);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if(left < right){
            stringBuilder.append(')');
            dfs(stringBuilder, left, right-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
