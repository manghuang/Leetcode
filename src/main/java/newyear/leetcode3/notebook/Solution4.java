package newyear.leetcode3.notebook;

public class Solution4 {

    public String removeDuplicates(String S) {
        if(S == null || S.length() == 0){
            return "";
        }
        return dfs(S);
    }

    private String dfs(String S) {
        int length = S.length();
        if(length == 0){
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char ch  = S.charAt(0);
        int num = 1;
        boolean changed = false;
        for (int i = 1; i < length; i++) {
            char c = S.charAt(i);
            if(c == ch){
                num++;
            }else {
                if(num > 1 && num % 2 == 0){
                    changed = true;
                }
                if(num % 2 == 1){
                    stringBuilder.append(ch);
                }
                ch = c;
                num = 1;
            }
        }
        if(num > 1 && num % 2 == 0){
            changed = true;
        }
        if(num % 2 == 1){
            stringBuilder.append(ch);
        }
        if(changed){
            return dfs(stringBuilder.toString());
        }else {
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String abbaca = new Solution4().removeDuplicates("aaaaaaaaa");
        System.out.println(abbaca);
    }
}
