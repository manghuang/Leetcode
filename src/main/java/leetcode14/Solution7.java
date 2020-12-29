package leetcode14;

import java.util.*;

public class Solution7 {

    public static void main(String[] args) {
        String res = new Solution7().countOfAtoms("H50");
        System.out.println(res);
    }

    public String countOfAtoms(String formula) {
        HashMap<String, Integer> res = dfs(formula);
        ArrayList<String> arrayList = new ArrayList<>(res.keySet());
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: arrayList
        ) {
            stringBuilder.append(s);
            if(res.get(s) > 1){
                stringBuilder.append(res.get(s));
            }
        }
        return stringBuilder.toString();
    }

    private HashMap<String, Integer> dfs(String str){
        HashMap<String, Integer> res = new HashMap<>();
        int length = str.length();

        boolean inColumn = false;
        int leftColumnNum = 0;
        int leftIndex = 0;
        int index = 0;

        while(index < length){
            char ch = str.charAt(index);
            if(inColumn){
                if(ch == '('){
                    leftColumnNum++;
                    index++;
                }else if(ch == ')'){
                    leftColumnNum--;
                    if(leftColumnNum == 0){
                        HashMap<String, Integer> temp = dfs(str.substring(leftIndex, index));
                        index++;
                        StringBuilder stringBuilder = new StringBuilder();
                        while (index < length && Character.isDigit(str.charAt(index))){
                            stringBuilder.append(str.charAt(index));
                            index++;
                        }
                        int num = 1;
                        if(stringBuilder.length()  > 0){
                            num = Integer.parseInt(stringBuilder.toString());
                        }
                        for (String s : temp.keySet()
                        ) {
                            res.put(s, res.getOrDefault(s, 0) +  num * temp.get(s));
                        }
                        inColumn = false;
                    }else {
                        index++;
                    }
                }else {
                    index++;
                }

            }else{
                if(ch == '('){
                    //
                    leftColumnNum = 1;
                    inColumn = true;
                    leftIndex = index+1;
                    index++;
                }else{
                    //分解为分子式和个数放入res
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ch);
                    index++;
                    while (index < length && (Character.isLowerCase(str.charAt(index)) ||
                            Character.isDigit(str.charAt(index)))){
                        stringBuilder.append(str.charAt(index));
                        index++;
                    }
//                    System.out.println(index);
                    String name;
                    int num = 1;
                    if(stringBuilder.length() == 1){
                        name = stringBuilder.toString();
                    }else if(stringBuilder.length() == 2){
                        if(Character.isLowerCase(stringBuilder.charAt(1))){
                            name = stringBuilder.toString();
                        }else {
                            name = String.valueOf(stringBuilder.charAt(0));
                            num = stringBuilder.charAt(1) - '0';
                        }
                    }else {
                        if(Character.isLowerCase(stringBuilder.charAt(1))){
                            name = stringBuilder.substring(0,2);
                            num = Integer.parseInt(stringBuilder.substring(2, stringBuilder.length()));
                        }else {
                            name = stringBuilder.substring(0,1);
                            num = Integer.parseInt(stringBuilder.substring(1, stringBuilder.length()));
                        }
                    }
                    res.put(name, res.getOrDefault(name, 0) + num);
                }
            }
        }
        return res;
    }


}
