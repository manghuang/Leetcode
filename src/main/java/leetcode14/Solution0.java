package leetcode14;

import java.util.LinkedList;

public class Solution0 {

    public String predictPartyVictory(String senate) {
        int length = senate.length();
        LinkedList<Integer> radQueue = new LinkedList<>();
        LinkedList<Integer> direQueue = new LinkedList<>();
//        boolean[] isCan = new boolean[length];
        for (int i = 0; i <length ; i++) {
            if(senate.charAt(i) == 'R'){
                radQueue.offer(i);
            }else {
                direQueue.offer(i);
            }
        }
        while (radQueue.size() > 0 && direQueue.size() > 0){
//            for (int i = 0; i < length; i++) {
//                if(!isCan[i]){
//                    if(senate.charAt(i) == 'R'){
//                        if(direQueue.isEmpty()){
//                            return "Radiant";
//                        }
//                        int next = direQueue.remove();
//                        isCan[next] = true;
//                    }else {
//                        if(radQueue.isEmpty()){
//                            return "Dire";
//                        }
//                        int next = radQueue.remove();
//                        isCan[next] = true;
//                    }
//                }
//            }
            Integer radNext = radQueue.remove();
            Integer direNext = direQueue.remove();
            if(radNext < direNext){
                radQueue.offer(radNext+length);
            }else {
                direQueue.offer(direNext+length);
            }
        }
        return  radQueue.size() > 0 ? "Radiant" : "Dire";
    }
}
