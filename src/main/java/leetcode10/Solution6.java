package leetcode10;

public class Solution6 {

    /*
        方法一：先得到具体的字符串，再比较
        方法二：直接比较
                从后到前，遇到#进行处理
     */
//    public boolean backspaceCompare(String S, String T) {
//        if(S == null || T == null){
//            return false;
//        }
//
//        LinkedList<Character> stackS  = getStack(S);
//        LinkedList<Character> stackT  = getStack(T);
//
//        int lengthS = stackS.size();
//        int lengthT = stackT.size();
//        if(lengthS != lengthT){
//            return false;
//        }else {
//            while (lengthS > 0){
//                if(!stackS.pop().equals(stackT.pop()) ){
//                    return false;
//                }
//                lengthS--;
//            }
//        }
//        return true;
//    }
//
//    private LinkedList<Character> getStack(String str) {
//        LinkedList<Character> stack = new LinkedList<>();
//        int lengthS = str.length();
//        for(int i=0; i<lengthS; i++){
//            char ch = str.charAt(i);
//            if(ch != '#'){
//                stack.push(ch);
//            }else{
//                if(!stack.isEmpty()){
//                    stack.pop();
//                }
//            }
//        }
//        return stack;
//    }
    public boolean backspaceCompare(String S, String T) {
        if(S == null || T == null){
            return false;
        }
        int lengthS = S.length()-1;
        int lengthT = T.length()-1;
        int skipS = 0;
        int skipT = 0;
        while (lengthS >= 0 || lengthT >= 0){
            while (lengthS >= 0){
                char chS = S.charAt(lengthS);
                if (chS == '#') {
                    skipS++;
                    lengthS--;
                }else if(skipS > 0){
                    skipS--;
                    lengthS--;
                }else {
                    break;
                }
            }
            while (lengthT >= 0){
                char chT = T.charAt(lengthT);
                if (chT == '#') {
                    skipT++;
                    lengthT--;
                }else if(skipT > 0){
                    skipT--;
                    lengthT--;
                }else {
                    break;
                }
            }
            if(lengthS >= 0 && lengthT >= 0){
                if(S.charAt(lengthS) != T.charAt(lengthT)){
                    return false;
                }
            }else {
                if(lengthS >=0 || lengthT >= 0){
                    return false;
                }
            }
            lengthS--;
            lengthT--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution6().backspaceCompare("a#b", "b");
        System.out.println(res);
    }

}
