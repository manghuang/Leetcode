package newyear.leetcode3.notebook;

public class Solution1 {

    private int index = 0;
    private String[] chs;
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return true;
        }
        chs = preorder.trim().split(",");
        if(dfs()){
            if(index == chs.length-1){
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean dfs() {
        if(index >= chs.length){
            return false;
        }
        if("#".equals(chs[index])){
            return true;
        }
        index++;
        boolean left = dfs();
        if(!left){
            return false;
        }
        index++;
        boolean right = dfs();
        if(!right){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "9,#,92,#,#";
//        System.out.println(str.charAt(3) == '#');

        boolean ans = new Solution1().isValidSerialization(str);
        System.out.println(ans);
    }
}
