package leetcode3;

public class Solution9 {
//    public boolean isPalindrome(int x) {
//        String str = String.valueOf(x);
//        int left = 0;
//        int right = str.length()-1;
//        while (left<right){
//            if(str.charAt(left) != str.charAt(right)){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

    public boolean isPalindrome(int x) {
        if(x <0 || (x%10 == 0 && x!= 0)){
            return false;
        }
        int temp = 0;
        while (x > temp){
            temp = temp*10 + x%10;
            x = x/10;
        }
        return x == temp || x == temp / 10;
    }
}
