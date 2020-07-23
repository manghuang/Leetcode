package leetcode3;

import org.jetbrains.annotations.NotNull;

public class Solution7 {
    /*
        三种关系：想等，不等，不知
        并查集
     */
    /*
         这种思想在不知道的情况下假设了不相等，后面没有合并的操作
     */
//    public boolean equationsPossible(String[] equations) {
//
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        int temp = 0;
//        for(String equation : equations){
//            char left = equation.charAt(0);
//            char right = equation.charAt(3);
//            if(left == right){
//                if (equation.charAt(1) == '=') {
//                    if(!hashMap.containsKey(left)){
//                        hashMap.put(left, temp++);
//                    }
//                }else {
//                    return false;
//                }
//            }else {
//                if(hashMap.containsKey(left)){
//                    if(hashMap.containsKey(right)){
//                        if(Objects.equals(hashMap.get(left), hashMap.get(right))){
//                            if(equation.charAt(1) == '!'){
//                                return false;
//                            }
//                        }else{
//                            if(equation.charAt(1) == '='){
//                                return false;
//                            }
//                        }
//                    }else{
//                        if (equation.charAt(1) == '=') {
//                            hashMap.put(right,hashMap.get(left));
//                        }else {
//                            hashMap.put(right,temp++);
//                        }
//                    }
//                }else {
//                    if(hashMap.containsKey(right)){
//                        if (equation.charAt(1) == '=') {
//                            hashMap.put(left,hashMap.get(right));
//                        }else {
//                            hashMap.put(left,temp++);
//                        }
//                    }else{
//                        if (equation.charAt(1) == '=') {
//                            hashMap.put(left,temp);
//                            hashMap.put(right, temp++);
//                        }else {
//                            hashMap.put(left,temp++);
//                            hashMap.put(right, temp++);
//                        }
//                    }
//                }
//            }
//
//        }
//
//        return true;
//    }

    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int @NotNull [] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int @NotNull [] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }


}
