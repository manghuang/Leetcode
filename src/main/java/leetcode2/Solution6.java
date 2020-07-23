package leetcode2;

import java.util.HashMap;

public class Solution6 {

    //枚举所有字串，选择符合条件的最小字串  会超出时间限制
    //选最长
    //选最短
    /*
        end - begin
         -- 答案区间
        t.length()
     */

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = new Solution6().minWindow(s, t);
        System.out.println(res);
    }

    //滑动窗口
//    public String minWindow(String s, String t) {
//        if(s == null || t == null || s.length() == 0|| t.length() == 0){
//            return "";
//        }
//        int begin = -1;
//        int end = s.length();
//        HashMap<Character, Integer> hpt = new HashMap<>();
//        for(int i=0; i<t.length(); i++){
//            char ch = t.charAt(i);
//            if(hpt.containsKey(ch)){
//                hpt.put(ch, hpt.get(ch)+1);
//            }else {
//                hpt.put(ch, 1);
//            }
//        }
//        for(int i=0; i<s.length(); i++){
//            if(end - begin + 1== t.length() || s.length()-i < t.length() ){
//                break;
//            }
//            HashMap<Character, Integer> hps= new HashMap<>();
//            for(int j=i; j<s.length(); j++){
//                char ch = s.charAt(j);
//                if(hps.containsKey(ch)){
//                    hps.put(ch, hps.get(ch)+1);
//                }else {
//                    hps.put(ch, 1);
//                }
//                if(j-i +1 <t.length()){
//                    continue;
//                }else if( j -i >= end - begin){
//                    break;
//                }
//                if(isok(hps, hpt)){
//                    begin = i;
//                    end = j;
//                    break;
//                }
//            }
//        }
//        if(begin != -1){
//            return s.substring(begin, end+1);
//        }else {
//            return "";
//        }
//    }
//    public String minWindow(String s, String t) {
//        int left = 0;
//        int right = 0;
//        HashMap<Character, Integer> hpt = new HashMap<>();
//        for(int i=0; i<t.length(); i++){
//            char ch = t.charAt(i);
//            if(hpt.containsKey(ch)){
//                hpt.put(ch, hpt.get(ch)+1);
//            }else {
//                hpt.put(ch, 1);
//            }
//        }
//        int begin = -1;
//        int end = s.length();
//        HashMap<Character, Integer> hps = new HashMap<>();
//        while (right<s.length()){
//            char ch = s.charAt(right);
//            if(hps.containsKey(ch)){
//                hps.put(ch, hps.get(ch)+1);
//            }else {
//                hps.put(ch, 1);
//            }
////            if(isok(hps, hpt)){
////                if(end - begin > right - left){
////                    begin = left;
////                    end = right;
////                }
////                while (left <= right){
////                    char ch1 = s.charAt(left);
////                    left++;
////                    hps.put(ch1, hps.get(ch1)-1);
////                    if(isok(hps, hpt)){
////                        if(end - begin > right - left){
////                            begin = left;
////                            end = right;
////                        }
////                    }else {
////                        break;
////                    }
////                }
////            }
//            while (isok(hps, hpt) && left <= right){
//                if(end - begin > right - left){
//                    begin = left;
//                    end = right;
//                }
//                char ch1 = s.charAt(left);
//                left++;
//                hps.put(ch1, hps.get(ch1)-1);
//            }
//            right++;
//        }
//        if(begin != -1){
//            return s.substring(begin, end+1);
//        }else {
//            return "";
//        }
//    }
//    private boolean isok(HashMap<Character, Integer> hps, HashMap<Character, Integer> hpt) {
//        for(Character ch :hpt.keySet()){
//            if(!hps.containsKey(ch) || hps.get(ch) < hpt.get(ch)){
//                return false;
//            }
//        }
//        return true;
//    }
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int slength = s.length();
        int tlength = t.length();
        if (slength == 0 || tlength == 0 || slength < tlength) {
            return "";
        }

        int begin = -1;
        int end = slength;

        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hp = new HashMap<>();
        for (int i = 0; i < tlength; i++) {
            char ch = t.charAt(i);
            hp.put(ch, hp.getOrDefault(ch, 0) + 1);
        }
//        System.out.println(hp);
        while (right < slength) {
            char ch = s.charAt(right);
            if (hp.containsKey(ch)) {
                hp.put(ch, hp.get(ch) - 1);
            }
//            System.out.print("left:" + left + "right:" + right);
//            System.out.println(hp);
            while (isok(hp) && left <= right) {
                if (end - begin > right - left) {
                    begin = left;
                    end = right;
                }
                char ch1 = s.charAt(left);
                left++;
                if (hp.containsKey(ch1)) {
                    hp.put(ch1, hp.get(ch1) + 1);
                }
//                System.out.print("left:" + left + "right:" + right);
//                System.out.println(hp);
            }
            right++;
        }

        return begin == -1 ? "" : s.substring(begin, end + 1);
    }

    private boolean isok(HashMap<Character, Integer> hp) {
        for (Character ch : hp.keySet()) {
            if (hp.get(ch) > 0) {
                return false;
            }
        }
        return true;
    }
}
